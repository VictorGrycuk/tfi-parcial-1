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
import service.infrastructure.inbound.ktor.dto.PrintRequest
import service.infrastructure.outbound.rabbitmq.RabbitService
import service.modules.Actions
import java.lang.Exception
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
                RabbitService().defaultExchangeAndQueue()

                post("/print") {
                    try {
                        val request = call.receive<PrintRequest>()
                        Actions.print(request.toDocument())

                    } catch (ex: Exception) {
                        print(ex.message)
                    }
                }
            }
        }

        return NettyAdapter(netty)
    }
}
