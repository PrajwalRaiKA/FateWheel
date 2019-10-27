package com.rai.fatewheel.application.services

import com.rai.fatewheel.data.entities.EngineerListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/engineers")
    fun getEngineersAsync(): Deferred<EngineerListResponse>
}

