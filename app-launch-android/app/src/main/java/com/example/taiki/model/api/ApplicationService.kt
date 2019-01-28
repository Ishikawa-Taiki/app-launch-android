package com.example.taiki.model.api

import retrofit2.http.GET
import rx.Observable

interface ApplicationService {
    @GET("exec?file=AndroidApplications&sheet=shopping")
    fun androidApplications(): Observable<List<ApplicationItemInformation>>
    @GET("exec?file=Services&sheet=shopping")
    fun services(): Observable<List<ServiceItemInformation>>
}