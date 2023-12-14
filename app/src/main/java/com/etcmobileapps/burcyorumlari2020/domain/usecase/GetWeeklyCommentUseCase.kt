package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.WeeklyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GetWeeklyCommentUseCase @Inject constructor(
    private val weeklyRepository: WeeklyRepository
) {
    operator fun invoke(horoscopeId: String): Single<HoroscopesResponseModel> {
        return weeklyRepository.getWeeklyCommentsById(horoscopeId)
    }

}