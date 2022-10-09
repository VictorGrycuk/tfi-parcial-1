package service.infrastructure.outbound.rabbitmq

import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DeliverCallback

class RabbitService {
    private val connectionFactory: ConnectionFactory = ConnectionFactory()
    private val channel = ConnectionFactory().newConnection().createChannel()

    init {
        connectionFactory.host = "localhost"
        connectionFactory.port = 5672
        connectionFactory.virtualHost = "/"
        connectionFactory.username = "guest"
        connectionFactory.password = "guest"
    }

    fun queueForPrintServer(): RabbitService {

        channel.exchangeDeclare("impressionExchange", "direct", true)
        channel.queueDeclare("impressionQueue", true, false, true, emptyMap())
        channel.queueBind("impressionQueue", "impressionExchange", "key")

        channel.exchangeDeclare("resultExchange", "direct", true)
        channel.queueDeclare("resultQueue", true, false, true, emptyMap())
        channel.queueBind("resultQueue", "resultExchange", "key")

        return this
    }

    fun listenForPrintServer() {
        val deliverCallback = DeliverCallback { consumerTag, message ->
            println(String(message.body))
        }
        val cancelCallback = CancelCallback { consumerTag -> print("Cancelled: $consumerTag") }

        channel.basicConsume("resultQueue", true, deliverCallback, cancelCallback)
//        channel.close()
//        connection.close()
    }

    fun publish(data: ByteArray) {
        channel.basicPublish("impressionExchange", "key", null, data)
    }
}