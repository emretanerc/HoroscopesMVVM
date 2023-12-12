package com.etcmobileapps.burcyorumlari2020.ui.horoscopedetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etcmobileapps.burcyorumlari2020.data.remote.DailyRepository
import com.etcmobileapps.burcyorumlari2020.data.remote.MontlyRepository
import com.etcmobileapps.burcyorumlari2020.data.remote.WeeklyRepository
import com.etcmobileapps.burcyorumlari2020.data.remote.YearlyRepository
import com.etcmobileapps.burcyorumlari2020.model.DailyResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val dailyRepository: DailyRepository,
    private val weeklyRepository: WeeklyRepository,
    private val montlyRepository: MontlyRepository,
    private val yearlyRepository: YearlyRepository
) : ViewModel() {
    private val disposable = CompositeDisposable()

    private val _dailyResponse = MutableLiveData<DailyResponseModel>()
    val dailyResponse: LiveData<DailyResponseModel> = _dailyResponse

    private val _montlyResponse = MutableLiveData<DailyResponseModel>()
    val montlyResponse: LiveData<DailyResponseModel> = _montlyResponse

    private val _weeklyResponse = MutableLiveData<DailyResponseModel>()
    val weeklyResponse: LiveData<DailyResponseModel> = _weeklyResponse

    private val _yearlyResponse = MutableLiveData<DailyResponseModel>()
    val yearlyResponse: LiveData<DailyResponseModel> = _yearlyResponse

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> = _errorState


    fun fetchDailyComments(horoscopeId: String) {
        disposable.add(dailyRepository.getDailyCommentsById(horoscopeId)
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
        disposable.add(weeklyRepository.getWeeklyCommentsById(horoscopeId)
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
        disposable.add(montlyRepository.getMontlyCommentsById(horoscopeId)
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
        disposable.add(montlyRepository.getMontlyCommentsById(horoscopeId)
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