package com.etcmobileapps.burcyorumlari2020.data.repository

import com.etcmobileapps.burcyorumlari2020.data.ApiService
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.YearlyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YearlyRepositoryImp @Inject constructor(private val service: ApiService):YearlyRepository {

    override fun getYearlyCommentsById(horoscopeId:String): Single<HoroscopesResponseModel> {
        return service.getYearly(horoscopeId)
    }

}