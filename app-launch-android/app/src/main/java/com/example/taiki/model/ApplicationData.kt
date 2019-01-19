package com.example.taiki.model

class ApplicationData(appName: String, packageName: String, tags: Array<String> = emptyArray()) {
    val appName = appName
    val packageName = packageName
    val tags = tags
}