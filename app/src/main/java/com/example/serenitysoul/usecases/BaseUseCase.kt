package com.example.serenitysoul.usecases

import com.example.serenitysoul.viewmodels.resource.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<in P, R>(private var coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default) {

    suspend operator fun invoke(parameters: P? = null, forceLoad: Boolean = false): Flow<Resource<R>> =
        execute(parameters, forceLoad)
            .catch { e -> emit(Resource.Fail(Exception(e))) }
            .flowOn(coroutineDispatcher)

    protected abstract suspend fun execute(parameters: P?, forceLoad: Boolean): Flow<Resource<R>>

}