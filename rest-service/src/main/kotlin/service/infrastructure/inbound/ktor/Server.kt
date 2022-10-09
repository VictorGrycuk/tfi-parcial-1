package service.infrastructure.inbound.ktor

import ServerConfiguration
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import service.domain.ServerInterface
import service.infrastructure.inbound.dto.PrintRequest
import service.infrastructure.outbound.rabbitmq.RabbitService
import service.modules.Actions
import java.time.Duration

object Server {
    fun getServer(serverConfig: ServerConfiguration, serverDI: ServerDI): ServerInterface {
        val netty = embeddedServer(Netty, port = serverConfig.port) {

            install(DefaultHeaders) { }
            install(CORS) { maxAge = Duration.ofDays(1) }
            install(ContentNegotiation) { gson { } }
            install(StatusPages) {
                exception<Throwable> { e ->
                    call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
                }
            }

            routing {
                RabbitService()
                    .queueForPrintServer()
                    .listenForPrintServer()

                post("/print") {
                    try {
                        val id = Actions.print(call.receive<PrintRequest>().toDocument())
                        call.respond(HttpStatusCode.Accepted, "Document queued as id $id")

                    } catch (ex: Exception) {
                        call.respond(HttpStatusCode.BadRequest, ex.message!!)
                    }
                }
            }
        }

        return NettyAdapter(netty)
    }
}
