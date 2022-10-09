package service.modules

import service.domain.MessageRepository
import service.infrastructure.outbound.rabbitmq.RabbitMessageRepository

object Repositories {
    val messageRepository: MessageRepository by lazy {
        RabbitMessageRepository()
    }
}