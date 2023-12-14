package com.etcmobileapps.burcyorumlari2020.data.repository

import com.etcmobileapps.burcyorumlari2020.data.ApiService
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.DailyRepository

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DailyRepositoryImpl @Inject constructor(private val service: ApiService):DailyRepository {
    override fun getDailyCommentsById(horoscopeId: String): Single<HoroscopesResponseModel> {
        return service.getDaily(horoscopeId)
    }

}