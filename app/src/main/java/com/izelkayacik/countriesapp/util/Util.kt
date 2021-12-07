package com.izelkayacik.countriesapp.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideContext
import com.bumptech.glide.request.RequestOptions
import com.izelkayacik.countriesapp.R

//Extension Fonksiyonu oluştururken hangi sınıfa extend edeceksek onu yazabiliyoruz.

/*
fun String.myExtension(myParameter: String){
    println(myParameter)
}
 */

//glide. veya opsiyonları belirleyip o şekilde başlayabiliriz

fun ImageView.downloadFromUrl(url: String?, progressDrawable : CircularProgressDrawable){

    //veriler gelirken text hızlı gelirken, image ler sonradan gelir
    //bu yüzden placeholder içerisinde progress bar koymalıyız.

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        //genişliği
        strokeWidth = 8f
        //yarıçapı
        centerRadius = 40f
        start()
    }
}