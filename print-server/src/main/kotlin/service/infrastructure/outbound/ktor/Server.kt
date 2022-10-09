package service.infrastructure.outbound.ktor

import ServerConfiguration
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import service.domain.ServerInterface
import service.infrastructure.inbound.rabbitmq.RabbitService
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
                RabbitService().listen(Actions.printDocument)
            }
        }

        return NettyAdapter(netty)
    }
}
