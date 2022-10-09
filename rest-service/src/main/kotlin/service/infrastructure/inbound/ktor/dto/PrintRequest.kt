package service.infrastructure.inbound.ktor.dto

import service.domain.Document
import service.infrastructure.inbound.exceptions.PriorityOutOfRangeException

data class PrintRequest(
    val content: String,
    val priority: Int = 1
) {
    fun toDocument(): Document {
        validatePriorityRange()
        return Document(content = content, priority = priority)
    }

    private fun validatePriorityRange() {
        if (!(1..10).contains(priority))
            throw PriorityOutOfRangeException("$priority is not within the valid range for priority")
    }
}