package com.ressac.modules.installedapplication

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import expo.modules.kotlin.Promise
import expo.modules.kotlin.exception.CodedException
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

// そんなに分ける必要ないので、全部一旦こちらを使用する
class NotWorkingException( message:String ):Exception (message)

class ExpoInstalledApplicationViewModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("ExpoInstalledApplicationView")

    AsyncFunction("launchForPackageName") { packageName: String ->
      val context = appContext.reactContext ?: throw NotWorkingException("reactContext is null")
      val intent = context.packageManager?.getLaunchIntentForPackage(packageName) ?: throw NotWorkingException("intent is null")
      context.startActivity(intent)
    }

    AsyncFunction("installedPackages") {
      val context = appContext.reactContext;
      val pm = context?.packageManager;
      pm?.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES)?.let {
        it.filter{ it.flags and ApplicationInfo.FLAG_SYSTEM == 0 }.map{ it.packageName }
      }
    }

    View(ExpoInstalledApplicationView::class) {
      Prop("packageName") { view: ExpoInstalledApplicationView, packageName: String ->
        val context = appContext.reactContext;
        val pm = context?.packageManager;
        var icon: Drawable? = try {
          pm?.getApplicationIcon(packageName)
        } catch (e: PackageManager.NameNotFoundException) {
          null
        }
        if (icon != null) {
          view.imageView.setImageDrawable(icon)
        }
        else {
          view.imageView.setImageResource(android.R.drawable.ic_menu_help)
        }
      }
    }
  }
}
