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
import service.infrastructure.inbound.dto.PrintLog
import service.infrastructure.inbound.exceptions.LogNotFoundException
import service.infrastructure.inbound.dto.PrintRequest
import service.infrastructure.inbound.dto.QueuedResponse
import service.infrastructure.outbound.rabbitmq.RabbitService
import service.modules.Actions
import service.modules.Repositories
import java.time.Duration
import java.util.*

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
                    .listenForPrintServer(Repositories.logRepository)

                post("/print") {
                    try {
                        val id = Actions.print(call.receive<PrintRequest>().toDocument())
                        call.respond(HttpStatusCode.Accepted, QueuedResponse(id).toJson())

                    } catch (ex: Exception) {
                        call.respond(HttpStatusCode.BadRequest, ex.message!!)
                    }
                }

                get("/getStatus") {
                    var id: UUID = UUID.randomUUID()
                    try {
                        id = UUID.fromString(call.request.queryParameters["id"])
                        val log = Actions.getStatus(id)
                        call.respond(HttpStatusCode.OK, log)
                    } catch (ex: LogNotFoundException) {
                        call.respond(HttpStatusCode.NotFound, PrintLog(id = id, result = "Not Found"))
                    } catch (ex: Exception) {
                        call.respond(HttpStatusCode.InternalServerError, ex.message!!)
                    }

                }
            }
        }

        return NettyAdapter(netty)
    }
}