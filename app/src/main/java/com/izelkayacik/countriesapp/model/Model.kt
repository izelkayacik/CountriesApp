package com.izelkayacik.countriesapp.model

import com.google.gson.annotations.SerializedName

data class Country(

    //value nin içerisindeki isim JSON da ki ile aynı olmak zorunda
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("capital")
    val countryCapital: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("language")
    val countryLanguage: String?,
    @SerializedName("flag")
    val imageUrl: String?)
