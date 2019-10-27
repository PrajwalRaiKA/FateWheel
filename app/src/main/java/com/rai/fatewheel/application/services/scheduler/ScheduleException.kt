package com.rai.fatewheel.application.services.scheduler

class ScheduleException : RuntimeException {


    constructor(message: String) : super(message) {}

    constructor(cause: Throwable) : super(cause) {}

    constructor(message: String, throwable: Throwable) : super(message, throwable) {}

    companion object {

        // General exception
        val SCHEDULE_GENERAL_EXCEPTION = "An error occurred while generating the schedule."
        // Invalid exception
        val SCHEDULE_INVALID_EXCEPTION = "Base on the given setting we can not create the schedule."
    }


}