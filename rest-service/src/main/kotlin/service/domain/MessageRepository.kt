package service.domain

interface MessageRepository {
    fun publish(document: Document)
}