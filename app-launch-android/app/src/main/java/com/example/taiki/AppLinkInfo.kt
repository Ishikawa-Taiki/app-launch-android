package com.example.taiki

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri

class AppLinkInfo(pm: PackageManager) {
    private val pm = pm
    private var link = mutableMapOf<String, PackageInfo>()

    fun addPackageInfo(packageName: String) {
        var packageInfo = PackageInfo(getAppIcon(packageName), getApp(packageName) ?: getStore(packageName))
        link.plusAssign(packageName to packageInfo)
    }

    fun getPackageInfo(packageName: String): PackageInfo? {
        return link[packageName]
    }

    private fun getApp(packageName: String): Intent? {
        var intent = pm.getLaunchIntentForPackage(packageName)
        return intent
    }

    private fun getStore(packageName: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("market://details?id=$packageName"))
        return intent
    }

    private fun getAppIcon(packageName: String): Drawable? {
        var icon = pm.getApplicationIcon(packageName)
        return icon
    }
}
