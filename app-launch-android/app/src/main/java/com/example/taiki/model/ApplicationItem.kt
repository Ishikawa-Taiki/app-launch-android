package com.example.taiki.model

class ApplicationItem(appName: String, packageName: String, tags: List<String> = emptyList<String>()): Item {
    val appName = appName
    val packageName = packageName
    val tags = tags
}