package service.infrastructure.data

import service.infrastructure.inbound.dto.PrintLog
import java.util.*

interface LogRepository {
    fun store(log: PrintLog)
    fun retrieve(id: UUID): PrintLog
}