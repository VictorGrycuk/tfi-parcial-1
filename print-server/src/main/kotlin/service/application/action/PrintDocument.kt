package service.application.action

import service.domain.Document
import service.infrastructure.outbound.dto.PrintLog
import service.infrastructure.outbound.exceptions.UnknownPrintException
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class PrintDocument {
    operator fun invoke(document: Document): String {
        // Simulemos un error
        if (document.filename == "invalid name") {
            throw UnknownPrintException("Something went wrong")
        }

        val timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneOffset.UTC)
            .format(Instant.now())
        return PrintLog(id = document.id, result = "OK", timestamp = timestamp, filename = document.filename).toJson()
    }
}