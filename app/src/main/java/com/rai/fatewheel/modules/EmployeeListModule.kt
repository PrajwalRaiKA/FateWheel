package com.rai.fatewheel.modules

import com.rai.fatewheel.data.repository.EmployeeListRepository
import com.rai.fatewheel.data.repository.EmployeeListRepositoryImpl
import com.rai.fatewheel.presentation.employeeList.EmployeeListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val employeeListModule = module {
    factory<EmployeeListRepository> { EmployeeListRepositoryImpl(apiService = get()) }
    // Specific viewModel pattern to tell Koin how to build MainViewModel
    viewModel { EmployeeListViewModel( employeeListRepository= get()) }
}