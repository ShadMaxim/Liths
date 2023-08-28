package com.example.serenitysoul.usecases.uc

import com.example.serenitysoul.data.Session
import com.example.serenitysoul.usecases.BaseUseCase
import com.example.serenitysoul.viewmodels.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 *
 * Можно попробовать во время загрузки сплаш экрана
 * подгружать последний использованный сеанс
 *
 * */
class SplashUseCase @Inject constructor(
//    private val splashInteractor: SplashInteractor
) : BaseUseCase<Unit, Session>() {

    override suspend fun execute(parameters: Unit?, forceLoad: Boolean): Flow<Resource<Session>> {
        TODO("Not yet implemented")
    }
}