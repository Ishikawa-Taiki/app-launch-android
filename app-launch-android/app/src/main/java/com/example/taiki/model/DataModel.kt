package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import java.util.*

object DataModel {
    private lateinit var context: Context
    private val screenStack = ArrayDeque<String>()

    fun init(appContext: Context) {
        context = appContext
    }

    fun pushScreen(screenName: String) {
        screenStack.push(screenName)
    }

    fun popScreen(): String? {
        return screenStack.pop()
    }

    fun peekScreen(): String? {
        return screenStack.peek()
    }

    fun getUseCaseList(): List<GroupItem> {
        return ApplicationConstant.shopMap.values.toList()
    }

    fun getItemList(titleName: String): List<Item> {
        return ApplicationConstant.shopMap[titleName]?.items ?: emptyList()
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

    fun getAppIcon(packageName: String): Drawable? {
        var icon: Drawable? = try {
            context.getPackageManager().getApplicationIcon(packageName)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        return icon
    }
}