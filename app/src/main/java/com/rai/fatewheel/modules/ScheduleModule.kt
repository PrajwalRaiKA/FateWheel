package com.rai.fatewheel.modules

import com.rai.fatewheel.data.repository.EmployeeListRepository
import com.rai.fatewheel.data.repository.EmployeeListRepositoryImpl
import com.rai.fatewheel.data.repository.ScheduleRepository
import com.rai.fatewheel.data.repository.ScheduleRepositoryImpl
import com.rai.fatewheel.presentation.employeeList.EmployeeListViewModel
import com.rai.fatewheel.presentation.schedule.ScheduleViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scheduleModule = module {
    factory<ScheduleRepository> { ScheduleRepositoryImpl() }
    // Specific viewModel pattern to tell Koin how to build MainViewModel
    viewModel { ScheduleViewModel(scheduleRepository = get()) }
}