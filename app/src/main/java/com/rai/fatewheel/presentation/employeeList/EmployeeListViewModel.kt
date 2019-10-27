package com.rai.fatewheel.presentation.employeeList

import androidx.lifecycle.MutableLiveData
import com.rai.fatewheel.base.BaseViewModel
import com.rai.fatewheel.data.entities.Engineer
import com.rai.fatewheel.data.repository.EmployeeListRepository
import com.rai.fatewheel.utils.UseCaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmployeeListViewModel(private val employeeListRepository: EmployeeListRepository) :
    BaseViewModel() {
    val showError = MutableLiveData<String>()
    val showLoading = MutableLiveData<Boolean>()
    val engineerList = MutableLiveData<ArrayList<Engineer>>()


    fun getEngineers() {
        showLoading.value = true
        launch {
            val result = withContext(Dispatchers.IO) { employeeListRepository.getEmployeeList() }
            showLoading.value = false
            when (result) {
                is UseCaseResult.Success -> engineerList.value = ArrayList(result.data.engineers)
                is UseCaseResult.Error -> showError.value = "Something went wrong"
            }
        }
    }
}
