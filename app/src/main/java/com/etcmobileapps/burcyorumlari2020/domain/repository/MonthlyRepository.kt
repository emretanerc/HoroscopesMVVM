package com.etcmobileapps.burcyorumlari2020.domain.repository

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import io.reactivex.rxjava3.core.Single

interface MonthlyRepository {
    fun getMonthlyCommentsById(horoscopeId: String): Single<HoroscopesResponseModel>
}