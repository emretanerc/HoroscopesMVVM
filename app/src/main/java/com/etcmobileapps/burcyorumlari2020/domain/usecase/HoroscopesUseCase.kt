package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.DailyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.MonthlyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.WeeklyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.YearlyRepository
import io.reactivex.rxjava3.core.Single


import javax.inject.Inject


class HoroscopesUseCase @Inject constructor(
    private val dailyRepository: DailyRepository,
    private val weeklyRepository: WeeklyRepository,
    private val monthlyRepository: MonthlyRepository,
    private val yearlyRepostiroy: YearlyRepository,
) {
    fun getDailyHoroscope(horoscopeId: String): Single<HoroscopesResponseModel> {
        return dailyRepository.getDailyCommentsById(horoscopeId)
    }

    fun getWeeklyHoroscope(horoscopeId: String): Single<HoroscopesResponseModel> {
        return weeklyRepository.getWeeklyCommentsById(horoscopeId)
    }

    fun getMontlyHoroscope(horoscopeId: String): Single<HoroscopesResponseModel> {
        return monthlyRepository.getMonthlyCommentsById(horoscopeId)
    }

    fun getYearlyHoroscope(horoscopeId: String): Single<HoroscopesResponseModel> {
        return yearlyRepostiroy.getYearlyCommentsById(horoscopeId)
    }

}