package service.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

data class Document(
    val content: String,
    val priority: Int = 1
) {
    fun toJson(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}