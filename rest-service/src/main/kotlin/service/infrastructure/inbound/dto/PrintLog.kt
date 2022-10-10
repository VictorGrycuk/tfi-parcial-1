package service.infrastructure.inbound.dto

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.util.*

data class PrintLog(
    val id: UUID = UUID.randomUUID(),
    val result: String = "",
    val timestamp: String = "",
    val filename: String = ""
) {
    companion object {
        fun fromJson(string: String): PrintLog = jacksonObjectMapper().readValue(string)
    }

    fun toJson(): String = jacksonObjectMapper().writeValueAsString(this)
}