package com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.etcmobileapps.burcyorumlari2020.R
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopeModel
import java.util.ArrayList


class HoroscopesViewModel(application: Application) : AndroidViewModel(application) {
    private var _horoscopeList = MutableLiveData<ArrayList<HoroscopeModel>>()
    var horoscopeList: LiveData<ArrayList<HoroscopeModel>> = _horoscopeList


    fun initHoroscopes() {
        val localHoroscopesList: ArrayList<HoroscopeModel> = ArrayList()
        localHoroscopesList.add(HoroscopeModel("koc", "Koç", R.drawable.koc, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("boga", "Boğa", R.drawable.boga, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("ikizler", "İkizler", R.drawable.ikizler, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("yengec", "Yengeç", R.drawable.yengec, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("aslan", "Aslan", R.drawable.aslan, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("basak", "Başak", R.drawable.basak, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("terazi", "Terazi", R.drawable.terazi, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("akrep", "Akrep", R.drawable.akrep, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("yay", "Yay", R.drawable.yay, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("oglak", "Oğlak", R.drawable.oglak, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("kova", "Kova", R.drawable.kova, "21 Mart - 20 Nisan"))
        localHoroscopesList.add(HoroscopeModel("balik", "Balık", R.drawable.balik, "21 Mart - 20 Nisan"))
        _horoscopeList.value = localHoroscopesList
    }
}
