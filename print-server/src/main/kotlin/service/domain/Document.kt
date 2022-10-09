package service.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.util.*

data class Document(
    val id: UUID = UUID.randomUUID(),
    val filename: String = "",
    val content: String = "",
    val priority: Int = 1
) {
    companion object {
        fun fromJson(string: String): Document = jacksonObjectMapper().readValue(string)
    }
}