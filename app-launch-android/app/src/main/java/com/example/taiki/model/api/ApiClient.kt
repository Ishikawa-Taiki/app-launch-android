package com.example.taiki.model.api

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import java.io.IOException


object ApiClient {
    val spreadSheetAccessBase =
        "https://script.google.com/macros/s/AKfycbzLNP_CPag82-Aw7r7QF8lQ2Y8kwBGjOVv_3BlZFXlflkYp5Bo/"

    fun application(): ApplicationService {
        val moshi = Moshi.Builder()
            .build()

        val timeOut: Long = 60
        val okClient = OkHttpClient.Builder()
            .callTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .build()

        val builder = Retrofit.Builder()
            .client(okClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(spreadSheetAccessBase)
            .build()

        return builder.create(ApplicationService::class.java)
    }
}
