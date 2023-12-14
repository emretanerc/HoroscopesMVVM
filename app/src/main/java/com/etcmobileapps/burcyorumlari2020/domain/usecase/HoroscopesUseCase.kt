package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.DailyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.MonthlyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.WeeklyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.YearlyRepository
import io.reactivex.rxjava3.core.Single


import javax.inject.Inject


data class HoroscopesUseCase @Inject constructor(
    val getDailyComments: GetDailyCommentUseCase,
    val getWeeklyComments: GetWeeklyCommentUseCase,
    val getMonthlyComments:GetMonthlyCommentUseCase,
    val getYearlyComments: GetYearlyCommentUseCase
)
