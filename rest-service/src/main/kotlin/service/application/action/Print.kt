package service.application.action

import service.domain.Document
import service.domain.MessageRepository

class Print(private val messageRepository: MessageRepository) {
    operator fun invoke(document: Document) {
        messageRepository.publish(document)
    }
}
