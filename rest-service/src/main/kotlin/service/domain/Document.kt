package service.domain

data class Document(
    val content: String,
    val priority: Int = 1
)