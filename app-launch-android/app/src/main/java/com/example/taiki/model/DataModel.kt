package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast
import com.example.taiki.model.api.ApiClient
import com.example.taiki.model.api.ApplicationItemInformation
import com.example.taiki.model.api.ServiceItemInformation
import com.example.taiki.model.api.onNext
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import android.content.ClipData
import android.content.ClipboardManager

object DataModel {
    private lateinit var context: Context

    fun init(appContext: Context) {
        context = appContext
        SaveData.init(appContext)
    }

    fun refreshSaveData(completed: ((Boolean) -> Unit)? = null) {
        val apiClient = ApiClient.application()
        Toast.makeText(context, "データ取得開始", Toast.LENGTH_SHORT).show();
        Observable.zip(
            apiClient.services(),
            apiClient.androidApplications(),
            { o1: List<ServiceItemInformation>, o2: List<ApplicationItemInformation> -> Pair(o1, o2) })
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .onNext {
                SaveData.saveServiceList(it.first)
                SaveData.saveApplicationList(it.second)
            }
            .onError {
                Toast.makeText(context, "データ取得失敗", Toast.LENGTH_SHORT).show();
                it.printStackTrace()
                completed?.let { it(false) }
            }
            .onCompleted {
                Toast.makeText(context, "データ取得成功", Toast.LENGTH_SHORT).show();
                completed?.let { it(true) }
            }
            .subscribe()
    }

    private fun convertItemFromWebAPIData(data: ServiceItemInformation): Item {
        return if (data.type.equals("group")) {
            GroupItem(data.data)
        } else if (data.type.equals("application")) {
            val targetApp = SaveData.loadApplicationList()?.find { it.shortName.equals(data.data) }
            ApplicationItem(targetApp!!.shortName, targetApp!!.packageName)
        } else if (data.type.equals("link")) {
            LinkItem(data.data)
        } else if (data.type.equals("title-text")) {
            TitleTextItem(data.data)
        } else {
            // data.type.equals("text")
            TextItem(data.data)
        }
    }


    fun getFilterItemList(filterName: String): List<Item> {
        val list = SaveData.loadServiceList()?.filter { it.parentName.equals(filterName) }?.map { convertItemFromWebAPIData(it) }
        return list ?: emptyList()
    }

    fun getInstalledItemList(): List<Item> {
        val pm = context.getPackageManager();
        val installedAppList = pm.getInstalledApplications(0);
        return installedAppList.map { ApplicationItem(it.loadLabel(pm).toString(), it.packageName) }.sortedWith(
            compareBy(String.CASE_INSENSITIVE_ORDER, { it.appName })
        )
    }

    fun getAppIntent(packageName: String): Intent {
        return getLaunchIntent(packageName) ?: getStoreIntent(packageName)
    }

    private fun getLaunchIntent(packageName: String): Intent? {
        var intent = context.getPackageManager().getLaunchIntentForPackage(packageName)
        return intent
    }

    private fun getStoreIntent(packageName: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("market://details?id=$packageName"))
        return intent
    }

    fun getLinkIntent(scheme: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(scheme))
        return intent
    }

    fun getAppIcon(packageName: String): Drawable? {
        var icon: Drawable? = try {
            context.getPackageManager().getApplicationIcon(packageName)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
        return icon
    }

    fun copyText(text: String): Boolean {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager;
        if (clipboardManager == null) {
            return false;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("", text));
        Toast.makeText(context, "コピーしました("+text+")", Toast.LENGTH_SHORT).show();
        return true;
    }
}