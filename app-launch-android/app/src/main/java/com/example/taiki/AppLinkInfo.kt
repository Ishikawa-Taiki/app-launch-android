package com.example.taiki

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

class AppLinkInfo(pm: PackageManager) {
    private val pm = pm
    private var link = mutableMapOf<String, PackageInfo>()

    public fun addPackageInfo(packageName: String) {
        var intent = getApp(packageName)
        var packageInfo = PackageInfo(intent != null, intent ?: getStore(packageName))
        link.plusAssign(packageName to packageInfo)
    }

    public fun getPackageInfo(packageName: String): PackageInfo? {
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
}
