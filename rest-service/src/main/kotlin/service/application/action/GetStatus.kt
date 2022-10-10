package service.application.action

import service.infrastructure.data.LogRepository
import service.infrastructure.inbound.dto.PrintLog
import java.util.*

class GetStatus(private val logRepository: LogRepository) {
    operator fun invoke(id: UUID): PrintLog {
        return logRepository.retrieve(id)
    }
}