package com.etcmobileapps.burcyorumlari2020.data

import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("get/{horoscopeId}")
    fun getDaily(@Path("horoscopeId") horoscopeId: String):  Single<HoroscopesResponseModel>

    @GET("get/{horoscopeId}/haftalik")
    fun getWeekly(@Path("horoscopeId") horoscopeId: String):  Single<HoroscopesResponseModel>

    @GET("get/{horoscopeId}/aylik")
    fun getMonthly(@Path("horoscopeId") horoscopeId: String):  Single<HoroscopesResponseModel>

    @GET("get/{horoscopeId}/yillik")
    fun getYearly(@Path("horoscopeId") horoscopeId: String):  Single<HoroscopesResponseModel>

}

