import service.infrastructure.inbound.ktor.Server
import service.infrastructure.inbound.ktor.ServerDI

fun main(args: Array<String>) {
    val serverDI = ServerDI(

    )
    val serverConfig = ServerConfiguration()
    val server = Server.getServer(serverConfig, serverDI)

    server.start(wait = true)
}

class ServerConfiguration(
    val port: Int = 8080
)