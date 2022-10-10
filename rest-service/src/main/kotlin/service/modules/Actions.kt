package service.modules

import service.application.action.GetStatus
import service.application.action.Print

object Actions {
    val print: Print by lazy {
        Print(Repositories.messageRepository)
    }

    val getStatus: GetStatus by lazy {
        GetStatus(Repositories.logRepository)
    }
}