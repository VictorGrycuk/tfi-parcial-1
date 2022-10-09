package service.infrastructure.outbound.rabbitmq

import com.rabbitmq.client.Channel
import service.domain.Document
import service.domain.MessageRepository

class RabbitMessageRepository: MessageRepository {
    private var channel: Channel

    init {
        val connection = RabbitService().getFactory().newConnection()
        channel = connection.createChannel()
    }

    override fun publish(document: Document) {
        channel.basicPublish("impressionExchange", "key", null, document.toJson().toByteArray())
    }
}