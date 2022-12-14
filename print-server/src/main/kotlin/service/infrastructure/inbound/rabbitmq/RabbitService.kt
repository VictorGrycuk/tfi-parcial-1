package service.infrastructure.inbound.rabbitmq

import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.Channel
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DeliverCallback
import service.application.action.PrintDocument
import service.domain.Document

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

    fun listen(printDocument: PrintDocument) {
        val connection = getFactory().newConnection()
        val channel = connection.createChannel()

        val deliverCallback = getDeliveryCallback(channel, printDocument)
        val cancelCallback = CancelCallback { consumerTag -> print("Cancelled: $consumerTag") }

        channel.basicConsume("impressionQueue", true, deliverCallback, cancelCallback)
    }

    private fun getDeliveryCallback(channel: Channel, printDocument: PrintDocument): DeliverCallback {
        return DeliverCallback { _, message ->
            try {
                val document = Document.fromJson(String(message.body))

                // De momento, si catcheo la excepción, se deja de escuchar la conexión
                if ((0..3).random() != 0) {
                    val result = printDocument(document)
                    channel.basicPublish("resultExchange", "key", null, result.toByteArray())
                } else (
                    println("document ${document.id} not printed")
                )
            } catch (ex: Exception) {
                // No hacemos nada
            }
        }
    }
}