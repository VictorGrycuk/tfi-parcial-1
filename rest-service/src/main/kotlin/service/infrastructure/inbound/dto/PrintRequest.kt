package service.infrastructure.inbound.dto

import service.domain.Document
import service.infrastructure.inbound.exceptions.EmptyContentException
import service.infrastructure.inbound.exceptions.PriorityOutOfRangeException

data class PrintRequest(
    val filename: String,
    val content: String,
    val priority: Int = 1
) {
    fun toDocument(): Document {
        validatePriorityRange()
        validateContent()
        validateFilename()
        return Document(content = content, priority = priority, filename = filename)
    }

    private fun validateFilename() {
        if(content.isEmpty())
            throw InvalidFilenameException("Filename can not be empty")
    }

    private fun validateContent() {
        if(content.isEmpty())
            throw EmptyContentException("Content can not be empty")
    }

    private fun validatePriorityRange() {
        if (!(1..10).contains(priority))
            throw PriorityOutOfRangeException("$priority is not within the valid range for priority")
    }
}