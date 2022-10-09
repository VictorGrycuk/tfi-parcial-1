package service.infrastructure.inbound.ktor.dto

import service.domain.Document

data class PrintRequest(
    val content: String,
    val priority: Int = 1
) {
    fun toDocument(): Document {
        return Document(content = content, priority = priority)
    }
}