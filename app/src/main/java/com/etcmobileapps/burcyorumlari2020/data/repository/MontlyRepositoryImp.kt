package com.etcmobileapps.burcyorumlari2020.data.repository

import com.etcmobileapps.burcyorumlari2020.data.ApiService
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.MonthlyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MontlyRepositoryImp @Inject constructor(private val service: ApiService) : MonthlyRepository {

    override fun getMonthlyCommentsById(horoscopeId: String): Single<HoroscopesResponseModel> {
        return service.getMonthly(horoscopeId)
    }

}