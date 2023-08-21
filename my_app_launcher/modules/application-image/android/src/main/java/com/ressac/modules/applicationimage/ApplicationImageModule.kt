package com.ressac.modules.applicationimage

import android.content.pm.PackageManager
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ApplicationImageModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ApplicationImage')` in JavaScript.
    Name("ApplicationImage")

    // Sets constant properties on the module. Can take a dictionary or a closure that returns a dictionary.
    Constants(
      "PI" to Math.PI
    )

    // Defines event names that the module can send to JavaScript.
    Events("onChange")

    // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    Function("hello") {
      "Hello world! 👋"
    }

    // Defines a JavaScript function that always returns a Promise and whose native code
    // is by default dispatched on the different thread than the JavaScript runtime runs on.
    AsyncFunction("setValueAsync") { value: String ->
      val pm = appContext.reactContext?.packageManager;
//      val installedAppList = pm?.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES);
//      println("async function called!!!" + installedAppList?.first())
      println("async function called!!! : " + value)
      val intent = pm?.getLaunchIntentForPackage(value)
      appContext.reactContext?.startActivity(intent)
      // Send an event to JavaScript.
      sendEvent("onChange", mapOf(
        "value" to value
      ))
    }

    AsyncFunction("launchForPackageName") { packageName: String ->
      val context = appContext.reactContext;
      context?.packageManager?.getLaunchIntentForPackage(packageName)?.let {
        context.startActivity(it)
      }
    }

    // Enables the module to be used as a native view. Definition components that are accepted as part of
    // the view definition: Prop, Events.
    View(ApplicationImageView::class) {
      // Defines a setter for the `name` prop.
      Prop("name") { view: ApplicationImageView, prop: String ->
        println(prop)
      }
    }
  }
}
