package service.infrastructure.outbound.rabbitmq

import com.rabbitmq.client.ConnectionFactory

class RabbitService {
    private val connectionFactory: ConnectionFactory = ConnectionFactory()

    init {
        connectionFactory.host = "localhost"
        connectionFactory.port = 5672
        connectionFactory.virtualHost = "/"
        connectionFactory.username = "guest"
        connectionFactory.password = "guest"
    }

    fun getFactory(): ConnectionFactory {
        return connectionFactory
    }

    fun defaultExchangeAndQueue() {
        val newConnection = getFactory().newConnection()
        val channel = newConnection.createChannel()

        channel.exchangeDeclare("impressionExchange", "direct", true)
        channel.queueDeclare("impressionQueue", true, false, true, emptyMap())
        channel.queueBind("impressionQueue", "impressionExchange", "key")

        channel.close()
        newConnection.close()
    }
}