package com.example.serenitysoul.usecases.uc

import com.example.serenitysoul.data.Session
import com.example.serenitysoul.usecases.BaseUseCase
import com.example.serenitysoul.viewmodels.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SessionUseCase @Inject constructor(
//    private val sessionInteractor: SessionInteractor
) : BaseUseCase<Unit, Session>() {

    override suspend fun execute(parameters: Unit?, forceLoad: Boolean): Flow<Resource<Session>> {
        TODO("Not yet implemented")
    }
}