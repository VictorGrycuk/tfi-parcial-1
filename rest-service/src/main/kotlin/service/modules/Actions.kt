package service.modules

import service.application.action.Print

object Actions {
    val print: Print by lazy {
        Print(Repositories.messageRepository)
    }
}