package service.application.action

import service.domain.Document
import service.domain.MessageRepository
import java.util.*

class Print(private val messageRepository: MessageRepository) {
    operator fun invoke(document: Document): UUID {
        messageRepository.publish(document)

        return document.id
    }
}
