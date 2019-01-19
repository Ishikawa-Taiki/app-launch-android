package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import java.util.*

object DataModel {
    private lateinit var context: Context
    // TODO: ArrayDeque の動作が想定と違うので、どこかで見直す。
    private val screenStack = ArrayDeque<ScreenInformation>()

    fun init(appContext: Context) {
        context = appContext
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

    private fun getRoot(): Map<String, Item> {
        return ShoppingConstant.groupMap
    }

    // TODO: データ構造を誤って気持ち悪いコードになってしまったので余力で直す
    fun getItemList(): List<Item> {
        val rootMap = getRoot()
        val queue = screenStack.clone()
        if (queue.size == 0) {
            return rootMap.values.toList()
        }
        if (queue.size == 1) {
            val select_1 = queue.pollLast()?.let { rootMap[it.title] }
            val select_1_list = if (select_1 is GroupItem) select_1.items else emptyList()
            return select_1_list
        }
        if (queue.size == 2) {
            val select_1 = queue.pollLast()?.let { rootMap[it.title] }
            val select_1_list = if (select_1 is GroupItem) select_1.items else emptyList()
            val select_2 = queue.pollLast()?.let { select_1_list[it.index] }
            val select_2_list = if (select_2 is GroupItem) select_2.items else emptyList()
            return select_2_list
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