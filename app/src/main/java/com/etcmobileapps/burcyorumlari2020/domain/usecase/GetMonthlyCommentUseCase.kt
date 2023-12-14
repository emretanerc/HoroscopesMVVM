package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.MonthlyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GetMonthlyCommentUseCase @Inject constructor(
    private val monthlyRepository: MonthlyRepository
) {
    operator fun invoke(horoscopeId: String): Single<HoroscopesResponseModel> {
        return monthlyRepository.getMonthlyCommentsById(horoscopeId)
    }

}