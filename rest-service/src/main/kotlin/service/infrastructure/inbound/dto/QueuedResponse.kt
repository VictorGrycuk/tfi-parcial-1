package service.infrastructure.inbound.dto

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.*

data class QueuedResponse(
    val id: UUID
) {
    fun toJson(): String = jacksonObjectMapper().writeValueAsString(this)
}