package com.example.taiki

import android.content.Intent

open class PackageInfo(installed: Boolean, intent: Intent) {
    var installed = installed
    var intent = intent
}
