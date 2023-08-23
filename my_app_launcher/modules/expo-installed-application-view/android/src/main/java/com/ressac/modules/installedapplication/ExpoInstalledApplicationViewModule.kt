package com.ressac.modules.installedapplication

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import expo.modules.kotlin.Promise
import expo.modules.kotlin.exception.CodedException
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

// class ExpoInstalledApplicationViewModule : Module() {
//   // Each module class must implement the definition function. The definition consists of components
//   // that describes the module's functionality and behavior.
//   // See https://docs.expo.dev/modules/module-api for more details about available components.
//   override fun definition() = ModuleDefinition {
//     // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
//     // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
//     // The module will be accessible from `requireNativeModule('ExpoInstalledApplicationView')` in JavaScript.
//     Name("ExpoInstalledApplicationView")

//     // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
//     Constants(
//       "PI" to Math.PI
//     )

//     // Defines event names that the module can send to JavaScript.
//     Events("onChange")

//     // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
//     Function("hello") {
//       "Hello world! 👋"
//     }

//     // Defines a JavaScript function that always returns a Promise and whose native code
//     // is by default dispatched on the different thread than the JavaScript runtime runs on.
//     AsyncFunction("setValueAsync") { value: String ->
//       // Send an event to JavaScript.
//       sendEvent("onChange", mapOf(
//         "value" to value
//       ))
//     }

//     // Enables the module to be used as a native view. Definition components that are accepted as part of
//     // the view definition: Prop, Events.
//     View(ExpoInstalledApplicationView::class) {
//       // Defines a setter for the `name` prop.
//       Prop("name") { view: ExpoInstalledApplicationView, prop: String ->
//         println(prop)
//       }
//     }
//   }
// }

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
