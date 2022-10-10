package service.modules

import service.domain.MessageRepository
import service.infrastructure.data.InMemoryLogRepository
import service.infrastructure.data.LogRepository
import service.infrastructure.outbound.rabbitmq.RabbitMessageRepository

object Repositories {
    val messageRepository: MessageRepository by lazy {
        RabbitMessageRepository()
    }

    val logRepository: LogRepository by lazy {
        InMemoryLogRepository()
    }
}