package com.etcmobileapps.burcyorumlari2020.data.remote

import com.etcmobileapps.burcyorumlari2020.data.ApiService
import com.etcmobileapps.burcyorumlari2020.model.DailyResponseModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YearlyRepository @Inject constructor(private val service: ApiService,) {

    fun getYearlyCommentsById(horoscopeId:String): Single<DailyResponseModel> {
        return service.getYearly(horoscopeId)
    }

}