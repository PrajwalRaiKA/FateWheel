package com.rai.fatewheel.data.repository

import com.rai.fatewheel.application.services.ApiService
import com.rai.fatewheel.data.entities.EngineerListResponse
import com.rai.fatewheel.utils.UseCaseResult
import kotlinx.coroutines.Deferred

interface EmployeeListRepository {
    suspend fun getEmployeeList(): UseCaseResult<EngineerListResponse>
}

class EmployeeListRepositoryImpl(val apiService: ApiService) : EmployeeListRepository {
    override suspend fun getEmployeeList(): UseCaseResult<EngineerListResponse> {
        return try {
            val result = apiService.getEngineers().await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

}