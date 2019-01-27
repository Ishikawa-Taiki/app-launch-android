package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import com.example.taiki.model.api.ApiClient
import com.example.taiki.model.api.ApplicationItemInformation
import com.example.taiki.model.api.ServiceItemInformation
import com.example.taiki.model.api.onNext
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

object DataModel {
    private lateinit var context: Context
    // TODO: ArrayDeque の動作が想定と違うので、どこかで見直す。
    private val screenStack = ArrayDeque<ScreenInformation>()

    private var serviceList: List<ServiceItemInformation>? = null
    private var applicationList: List<ApplicationItemInformation>? = null

    fun init(appContext: Context) {
        context = appContext
    }

    fun refreshSaveData() {
        val apiClient = ApiClient.application()
        apiClient.services()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .onNext {
                serviceList = it
            }
            .subscribe()
        apiClient.androidApplications()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .onNext {
                applicationList = it
            }.subscribe()
    }

    fun pushScreen(screen: ScreenInformation) {
        screenStack.push(screen)
    }

    fun popScreen(): ScreenInformation? {
        return try {
            screenStack.pop()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    fun peekScreen(): ScreenInformation? {
        return try {
            screenStack.peek()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    private fun convertItemFromWebAPIData(data: ServiceItemInformation): Item {
        return if (data.type.equals("group")) {
            GroupItem(data.data)
        }
        else if (data.type.equals("text")) {
            InformationItem(data.data)
        }
        else if (data.type.equals("title-text")) {
            InformationItem(data.data)
        }
        else if (data.type.equals("link")) {
            InformationItem("LINK：", data.data)
        }
        else if (data.type.equals("application")) {
            val targetApp = applicationList?.find { it.shortName.equals(data.data) }
            ApplicationItem(targetApp!!.shortName, targetApp!!.packageName)
        }
        else {
            InformationItem(data.data)
        }
    }

    fun getItemList(): List<Item> {
        val filterName = peekScreen()?.title ?: "root"
        val list = serviceList?.filter { it.parentName.equals(filterName) }?.map { convertItemFromWebAPIData(it) }
        return list ?: emptyList()
    }

    fun getAppIntent(packageName: String): Intent {
        return getLaunchIntent(packageName) ?: getStoreIntent(packageName)
    }

    private fun getLaunchIntent(packageName: String): Intent? {
        var intent = context.getPackageManager().getLaunchIntentForPackage(packageName)
        return intent
    }

    private fun getStoreIntent(packageName: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("market://details?id=$packageName"))
        return intent
    }

    fun getLinkIntent(scheme: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(scheme))
        return intent
    }

    fun getAppIcon(packageName: String): Drawable? {
        var icon: Drawable? = try {
            context.getPackageManager().getApplicationIcon(packageName)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        return icon
    }
}