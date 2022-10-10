package service.infrastructure.data

import service.infrastructure.inbound.dto.PrintLog
import service.infrastructure.inbound.exceptions.LogNotFoundException
import java.util.*

class InMemoryLogRepository: LogRepository {
    private val printedDocuments = mutableListOf<PrintLog>()

    override fun store(log: PrintLog) {
        printedDocuments.add(log)
    }

    override fun retrieve(id: UUID): PrintLog {
        return printedDocuments.find { log -> log.id == id } ?: throw LogNotFoundException("Log with id $id not found")
    }
}