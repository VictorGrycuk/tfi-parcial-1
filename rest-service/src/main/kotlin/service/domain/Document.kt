package service.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.*

data class Document(
    val id: UUID = UUID.randomUUID(),
    val content: String = "",
    val priority: Int = 1
) {
    fun toJson(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}