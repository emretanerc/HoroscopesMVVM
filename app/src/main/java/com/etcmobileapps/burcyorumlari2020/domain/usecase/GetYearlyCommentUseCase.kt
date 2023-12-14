package com.etcmobileapps.burcyorumlari2020.domain.usecase

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.repository.YearlyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GetYearlyCommentUseCase @Inject constructor(
    private val yearlyRepostiroy: YearlyRepository
) {

    operator fun invoke(horoscopeId: String): Single<HoroscopesResponseModel> {
        return yearlyRepostiroy.getYearlyCommentsById(horoscopeId)
    }

}