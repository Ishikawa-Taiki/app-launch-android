package com.example.taiki.model

import android.content.Context
import com.example.taiki.model.api.ApplicationItemInformation
import com.example.taiki.model.api.ServiceItemInformation

object SaveData {
    private lateinit var context: Context
    private var serviceList: List<ServiceItemInformation>? = null
    private var applicationList: List<ApplicationItemInformation>? = null

    fun init(appContext: Context) {
        context = appContext
    }

    fun saveServiceList(saveData: List<ServiceItemInformation>?) {
        serviceList = saveData
    }
    fun loadServiceList(): List<ServiceItemInformation>? {
        return serviceList
    }
    fun saveApplicationList(saveData: List<ApplicationItemInformation>?) {
        applicationList = saveData
    }
    fun loadApplicationList(): List<ApplicationItemInformation>? {
        return applicationList
    }
}
