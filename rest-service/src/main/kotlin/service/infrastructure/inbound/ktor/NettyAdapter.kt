package service.infrastructure.inbound.ktor

import io.ktor.server.netty.*
import service.domain.ServerInterface

class NettyAdapter(private val nettyEngine: NettyApplicationEngine): ServerInterface {
    override fun start(wait: Boolean) {
        nettyEngine.start(wait)
    }
}