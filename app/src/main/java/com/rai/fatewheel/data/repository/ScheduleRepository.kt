package com.rai.fatewheel.data.repository

import com.rai.fatewheel.application.services.scheduler.ScheduleService
import com.rai.fatewheel.data.entities.Engineer
import com.rai.fatewheel.data.entities.Schedule

interface ScheduleRepository {
    fun getSchedule(engineerList: ArrayList<Engineer>): List<Schedule>
}


class ScheduleRepositoryImpl : ScheduleRepository {
    override fun getSchedule(engineerList: ArrayList<Engineer>): List<Schedule> {
        val scheduleService = ScheduleService(engineerList)
        return scheduleService.schedules!!
    }

}