package com.example.taiki.model

class ApplicationData(appName: String, packageName: String, elementTags: Array<String>) {
    var appName: String = appName // title
    var packageName: String = packageName // detail
    var elementTags: Array<String> = elementTags // filterとかしたくなった時のための付属情報
}