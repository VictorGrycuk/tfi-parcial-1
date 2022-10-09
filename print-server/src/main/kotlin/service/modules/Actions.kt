package service.modules

import service.application.action.PrintDocument

object Actions {
    val printDocument: PrintDocument by lazy {
        PrintDocument()
    }
}