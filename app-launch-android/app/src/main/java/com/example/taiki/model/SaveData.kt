package com.example.taiki.model

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.taiki.model.api.ApplicationItemInformation
import com.example.taiki.model.api.ServiceItemInformation
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.JsonAdapter

object SaveData {
    private lateinit var preferences: SharedPreferences
    private val keyServiceList = "ServiceList-SaveData"
    private val keyApplicationList = "ApplicationList-SaveData"

    fun init(appContext: Context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    fun saveServiceList(saveData: List<ServiceItemInformation>?) {
        saveData?.let {
            val jsonText = serviceListAdapter().toJson(it)
            save(keyServiceList, jsonText)
        }
    }

    fun loadServiceList(): List<ServiceItemInformation>? {
        val loadData = load(keyServiceList)?.let {
            serviceListAdapter().fromJson(it)
        }
        return loadData
    }

    private fun serviceListAdapter(): JsonAdapter<List<ServiceItemInformation>> {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ServiceItemInformation::class.java)
        val listAdapter: JsonAdapter<List<ServiceItemInformation>> = moshi.adapter(type)
        return listAdapter
    }

    fun saveApplicationList(saveData: List<ApplicationItemInformation>?) {
        saveData?.let {
            val jsonText = applicationListAdapter().toJson(it)
            save(keyApplicationList, jsonText)
        }
    }

    fun loadApplicationList(): List<ApplicationItemInformation>? {
        val loadData = load(keyApplicationList)?.let {
            applicationListAdapter().fromJson(it)
        }
        return loadData
    }

    private fun applicationListAdapter(): JsonAdapter<List<ApplicationItemInformation>> {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ApplicationItemInformation::class.java)
        val listAdapter: JsonAdapter<List<ApplicationItemInformation>> = moshi.adapter(type)
        return listAdapter
    }

    private fun save(key: String, value: String?) {
        preferences.edit().putString(key, value).apply();
    }

    private fun load(key: String): String? {
        return preferences.getString(key, null);
    }
}
