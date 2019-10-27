package com.rai.fatewheel.presentation.schedule

import androidx.lifecycle.MutableLiveData
import com.rai.fatewheel.base.BaseViewModel
import com.rai.fatewheel.data.entities.Engineer
import com.rai.fatewheel.data.entities.Schedule
import com.rai.fatewheel.data.repository.ScheduleRepository
import kotlinx.coroutines.launch

class ScheduleViewModel(var scheduleRepository: ScheduleRepository) : BaseViewModel() {
    var scheduleList = MutableLiveData<List<Schedule>>()


    fun getSchedule(engineerList: ArrayList<Engineer>) {
        launch {
            scheduleList.value = scheduleRepository.getSchedule(engineerList)
        }
    }
}
