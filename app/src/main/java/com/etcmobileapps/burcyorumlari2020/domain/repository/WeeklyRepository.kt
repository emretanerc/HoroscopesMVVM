package com.etcmobileapps.burcyorumlari2020.domain.repository

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import io.reactivex.rxjava3.core.Single

interface WeeklyRepository {
    fun getWeeklyCommentsById(horoscopeId: String): Single<HoroscopesResponseModel>
}