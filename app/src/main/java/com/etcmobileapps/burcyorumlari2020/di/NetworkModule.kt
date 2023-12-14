package com.etcmobileapps.burcyorumlari2020.di


import com.etcmobileapps.burcyorumlari2020.BuildConfig
import com.etcmobileapps.burcyorumlari2020.data.ApiService
import com.etcmobileapps.burcyorumlari2020.data.repository.DailyRepositoryImpl
import com.etcmobileapps.burcyorumlari2020.data.repository.MontlyRepositoryImp
import com.etcmobileapps.burcyorumlari2020.data.repository.WeeklyRepositoryImp
import com.etcmobileapps.burcyorumlari2020.data.repository.YearlyRepositoryImp
import com.etcmobileapps.burcyorumlari2020.domain.repository.DailyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.MonthlyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.WeeklyRepository
import com.etcmobileapps.burcyorumlari2020.domain.repository.YearlyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(okHttpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        OkHttpClient.Builder().apply {
            callTimeout(40, TimeUnit.SECONDS)
            connectTimeout(40, TimeUnit.SECONDS)
            readTimeout(40, TimeUnit.SECONDS)
            addInterceptor(okHttpLoggingInterceptor)
            return build()
        }
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDailyRepository(
        retrofitService: ApiService
    ): DailyRepository {
        return DailyRepositoryImpl(retrofitService)
    }

    @Singleton
    @Provides
    fun provideWeeklyRepository(
        retrofitService: ApiService
    ): WeeklyRepository {
        return WeeklyRepositoryImp(retrofitService)
    }

    @Singleton
    @Provides
    fun provideMonthlyRepository(
        retrofitService: ApiService
    ): MonthlyRepository {
        return MontlyRepositoryImp(retrofitService)
    }

    @Singleton
    @Provides
    fun provideYearlyRepository(
        retrofitService: ApiService
    ): YearlyRepository {
        return YearlyRepositoryImp(retrofitService)
    }
}