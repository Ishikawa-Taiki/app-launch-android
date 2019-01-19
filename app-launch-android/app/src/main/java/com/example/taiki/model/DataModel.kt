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
        return try {
            screenStack.pop()
        } catch (e: EmptyStackException) {
            null
        }
    }

    fun peekScreen(): String? {
        return try {
            screenStack.peek()
        } catch (e: EmptyStackException) {
            null
        }
    }

    private fun getRoot(): Map<String, Item> {
        return ApplicationConstant.shopMap
    }

    fun getItemList(): List<Item> {
        val rootMap = getRoot()
        val queue = screenStack.clone()
        if (queue.size == 0) {
            return rootMap.values.toList()
        }
        if (queue.size == 1) {
            val select_1 = queue.poll()?.let { rootMap[it] }
            val select_1_list = if (select_1 is GroupItem) select_1.items else emptyList()
            return select_1_list
        }
        return emptyList()
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