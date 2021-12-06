package com.izelkayacik.countriesapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izelkayacik.countriesapp.model.Country
import com.izelkayacik.countriesapp.service.CountryAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel(){

    private val countryApiService = CountryAPIService()
    //private val tag : String = FeedViewModel.g

    //Oluşturulan obje de Call yaptıkça, veri indirdikçe disposable ın içine atarız.
    //kullan-at ile hafızamızı daha verimli kullanırız.

    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        getDataFromAPI()
    }

    private fun getDataFromAPI(){
        //kullanıcı ilk progress barı görsün
        countryLoading.value = true

        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(t: List<Country>) {
                        Log.d("Service" , "Success")
                        countries.value = t
                        countryError.value = false
                        countryLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        Log.d("Service" , "Failed: ${e.message} ")
                        countryLoading.value = false
                        countryError.value = true
                        e.printStackTrace()
                    }

                })
        )
    }
}