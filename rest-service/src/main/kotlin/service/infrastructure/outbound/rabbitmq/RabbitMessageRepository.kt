package service.infrastructure.outbound.rabbitmq

import service.domain.Document
import service.domain.MessageRepository

class RabbitMessageRepository: MessageRepository {
    private val service = RabbitService()

    override fun publish(document: Document) {
        service.publish(document.toJson().toByteArray())
    }
}