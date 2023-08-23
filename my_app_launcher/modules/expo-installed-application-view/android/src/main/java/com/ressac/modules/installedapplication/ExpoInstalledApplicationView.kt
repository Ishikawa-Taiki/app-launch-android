package com.ressac.modules.installedapplication

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

class ExpoInstalledApplicationView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    internal val webView = WebView(context).also {
        it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        it.webViewClient = object : WebViewClient() {}
        addView(it)

        it.loadUrl("https://docs.expo.dev/modules/")
    }
}
