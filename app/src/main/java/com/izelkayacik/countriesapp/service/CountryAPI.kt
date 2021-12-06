package com.izelkayacik.countriesapp.service

import com.izelkayacik.countriesapp.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    //BASE URL -> https://raw.githubusercontent.com/atilsamancioglu/
    //EXT -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    //GET, POST
    //Hangi adresten indireceğini söylememiz gerekiyor.
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    @GET("IA19-DataSetCountries/master/countrydataset.json")
    //Hangi fonksiyonun içine atacağını söylüyorum.
    //Single Observable gibi çalışır.
    //İçerisine type yazarak kullanılır. Bir list alacağız ve Country modelleri gelecek.
    //Single bir defa bu işlemi alır ve durur.
    fun getCountries():Single<List<Country>>

}