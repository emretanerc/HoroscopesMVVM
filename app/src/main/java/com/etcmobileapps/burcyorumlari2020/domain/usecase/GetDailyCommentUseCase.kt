package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.DailyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetDailyCommentUseCase @Inject constructor(
    private val dailyRepository: DailyRepository,
) {
    operator fun invoke(horoscopeId: String): Single<HoroscopesResponseModel> {
        return dailyRepository.getDailyCommentsById(horoscopeId)
    }

}