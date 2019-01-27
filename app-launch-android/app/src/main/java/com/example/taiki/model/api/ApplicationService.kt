package com.example.taiki.model.api

import retrofit2.http.GET
import rx.Observable

interface ApplicationService {
    @GET("exec?file=app&sheet=shopping")
    fun shopping(): Observable<List<ApplicationItemInformation>>
}