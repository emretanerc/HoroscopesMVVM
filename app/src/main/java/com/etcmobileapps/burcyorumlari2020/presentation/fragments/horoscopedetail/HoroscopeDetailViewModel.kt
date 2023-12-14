package com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopesResponseModel
import com.etcmobileapps.burcyorumlari2020.domain.usecase.HoroscopesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val horoscopesUseCase: HoroscopesUseCase
) : ViewModel() {
    private val disposable = CompositeDisposable()

    private val _dailyResponse = MutableLiveData<HoroscopesResponseModel>()
    val dailyResponse: LiveData<HoroscopesResponseModel> = _dailyResponse

    private val _montlyResponse = MutableLiveData<HoroscopesResponseModel>()
    val montlyResponse: LiveData<HoroscopesResponseModel> = _montlyResponse

    private val _weeklyResponse = MutableLiveData<HoroscopesResponseModel>()
    val weeklyResponse: LiveData<HoroscopesResponseModel> = _weeklyResponse

    private val _yearlyResponse = MutableLiveData<HoroscopesResponseModel>()
    val yearlyResponse: LiveData<HoroscopesResponseModel> = _yearlyResponse

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> = _errorState


     fun fetchDailyComments(horoscopeId: String) {
        disposable.add(horoscopesUseCase.getDailyComments(horoscopeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    run {
                        _dailyResponse.value = result
                        _errorState.value = false
                    }
                },
                { error -> _errorState.value = true }
            ))
    }



    fun fetchWeeklyComments(horoscopeId: String) {
        disposable.add(horoscopesUseCase.getWeeklyComments(horoscopeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    run {
                        _weeklyResponse.value = result
                        _errorState.value = false
                    }
                },
                { error -> _errorState.value = true }
            ))
    }

    fun fetchMontlyComments(horoscopeId: String) {
        disposable.add(horoscopesUseCase.getMonthlyComments(horoscopeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    run {
                        _montlyResponse.value = result
                        _errorState.value = false
                    }
                },
                { error -> _errorState.value = true }
            ))
    }

    fun fetchYearlyComments(horoscopeId: String) {
        disposable.add(horoscopesUseCase.getYearlyComments(horoscopeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    run {
                        _yearlyResponse.value = result
                        _errorState.value = false
                    }
                },
                { error -> _errorState.value = true }
            ))
    }



    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}