import service.infrastructure.outbound.ktor.Server
import service.infrastructure.outbound.ktor.ServerDI

fun main(args: Array<String>) {
    val serverDI = ServerDI(

    )
    val serverConfig = ServerConfiguration()
    val server = Server.getServer(serverConfig, serverDI)

    server.start(wait = true)
}

class ServerConfiguration(
    val port: Int = 8081
)