package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri

object DataModel {
    lateinit var context: Context

    // 対応ユースケースリスト(仮)
    private val useCaseList: Array<UseCaseData> = arrayOf(
        UseCaseData("ブラウザ", "Chrome"),
        UseCaseData("ブラウザ", "Youtube"),
        UseCaseData("メール", "Gmail"),
        UseCaseData("動画", "Youtube")
    )

    // 対応パッケージリスト(仮)
    private val applicationList: Array<ApplicationData> = arrayOf(
        ApplicationData("Chrome", "com.android.chrome", emptyArray()),
        ApplicationData("Gmail", "com.google.android.gm", emptyArray()),
        ApplicationData("Youtube", "com.google.android.youtube", emptyArray())
    )

    fun init(appContext: Context) {
        context = appContext
    }

    fun getUseCaseList(): Array<UseCaseData> {
        return useCaseList
    }

    fun getApplicationList(): Array<ApplicationData> {
        return applicationList
    }

    fun getAppIntent(packageName: String): Intent? {
        var intent = context.getPackageManager().getLaunchIntentForPackage(packageName)
        return intent
    }

    fun getStoreIntent(packageName: String): Intent {
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