package com.ressac.modules.installedapplication

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.widget.ImageView
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

class ExpoInstalledApplicationView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    internal val imageView = ImageView(context).also {
        it.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(it)
    }
}
