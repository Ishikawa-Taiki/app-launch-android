package com.example.taiki.model

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri

object DataModel {
    lateinit var context: Context

    // アプリがないケースを想定していなかったので仮...
    private val NO_APP = "[EMPTY]"

    // 対応ユースケースリスト(仮)
    private val useCaseList = arrayOf(
        UseCaseData("ハナマサプラス", NO_APP),
        UseCaseData("ライフ", "ライフ 公式アプリ"),
        UseCaseData("ライフ", "Pontaカード(公式)"),
        UseCaseData("ライフ", "ｄポイントクラブ"),
        UseCaseData("まいばすけっと", NO_APP),
        UseCaseData("トモズ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("トモズ", "トクバイ - 無料チラシアプリ／スーパー掲載数No.1"),
        UseCaseData("トモズ", "Pontaカード(公式)"),
        UseCaseData("トモズ", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("トモズ", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("ウェルパーク", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("くすりのダイイチ", NO_APP),
        UseCaseData("ドンキ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ドンキ", "majica～ドン・キホーテグループの電子マネー公式アプリ～"),
        UseCaseData("イオン", "イオンお買物"),
        UseCaseData("PARCO", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("PARCO", "Origami スマホ決済アプリ"),
        UseCaseData("ローソン", "ローソン"),
        UseCaseData("ローソン", "Pontaカード(公式)"),
        UseCaseData("ローソン", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ローソン", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("ローソン", "Origami スマホ決済アプリ"),
        UseCaseData("ファミマ", "Tポイント"),
        UseCaseData("ファミマ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ファミマ", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("ファミマ", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("セブイレ", NO_APP),
        UseCaseData("サークルKサンクス", "Tポイント"),
        UseCaseData("ミニストップ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ミニストップ", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("ミニストップ", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("NewDays", NO_APP),
        UseCaseData("ローソンストア100", "Pontaカード(公式)"),
        UseCaseData("ローソンストア100", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ローソンストア100", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("ローソンストア100", "Origami スマホ決済アプリ"),
        UseCaseData("ビックカメラ", "ビックカメラ"),
        UseCaseData("ビックカメラ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ビックカメラ", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("ヨドバシカメラ", "ヨドバシゴールドポイントカード"),
        UseCaseData("ソフマップ", "ビックカメラ"),
        UseCaseData("ソフマップ", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("ソフマップ", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("アニメイト", "アニメイトアプリ"),
        UseCaseData("らしんばん", NO_APP),
        UseCaseData("K-BOOKS", NO_APP),
        UseCaseData("ゲーマーズ", NO_APP),
        UseCaseData("とらのあな", "Origami スマホ決済アプリ"),
        UseCaseData("とらのあな", "PayPay-QRコード・バーコードで支払うスマホアプリ"),
        UseCaseData("メディアライン", "ｄポイントクラブ"),
        UseCaseData("ジュンク堂書店", "Pontaカード(公式)"),
        UseCaseData("ジュンク堂書店", "楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える"),
        UseCaseData("ブックオフ", "BOOKOFF ブックオフ公式アプリ　ポイントが貯まる・使える"),
        UseCaseData("タワーレコード", "ｄポイントクラブ"),
        UseCaseData("アクシーズ ファム", "axes femme"),
        UseCaseData("ジーンズメイト", "Origami スマホ決済アプリ"),
        UseCaseData("東京靴流通センター", "靴専門店　東京靴流通センター"),
        UseCaseData("LOFT", "LINE（ライン） - 無料通話・メールアプリ"),
        UseCaseData("LOFT", "Origami スマホ決済アプリ"),
        UseCaseData("TSUTAYA", "Tポイント"),
        UseCaseData("ゲオ", "Pontaカード(公式)"),
        UseCaseData("ゲオ", "LINE（ライン） - 無料通話・メールアプリ")
    )

    // 対応パッケージリスト(仮)
    private val applicationList = arrayOf(
        ApplicationData("ライフ 公式アプリ", "jp.co.lifecorp.android.app"),
        ApplicationData("Pontaカード(公式)", "jp.ponta.myponta"),
        ApplicationData("ｄポイントクラブ", "com.nttdocomo.android.dpoint"),
        ApplicationData("LINE（ライン） - 無料通話・メールアプリ", "jp.naver.line.android"),
        ApplicationData("トクバイ - 無料チラシアプリ／スーパー掲載数No.1", "jp.co.tokubai.android.bargain"),
        ApplicationData("楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える", "jp.co.rakuten.pay"),
        ApplicationData("PayPay-QRコード・バーコードで支払うスマホアプリ", "jp.ne.paypay.android.app"),
        ApplicationData("majica～ドン・キホーテグループの電子マネー公式アプリ～", "com.donki.majica"),
        ApplicationData("イオンお買物", "jp.aeonretail.aeon_okaimono"),
        ApplicationData("Origami スマホ決済アプリ", "co.origami.android"),
        ApplicationData("ローソン", "jp.co.lawson.android"),
        ApplicationData("Tポイント", "jp.co.ccc.Tsite"),
        ApplicationData("ビックカメラ", "com.biccamera.android.mobile"),
        ApplicationData("ヨドバシゴールドポイントカード", "com.yodobashi.coupon"),
        ApplicationData("アニメイトアプリ", "jp.co.animate.mobileApp"),
        ApplicationData("BOOKOFF ブックオフ公式アプリ　ポイントが貯まる・使える", "jp.co.bookoff.bookoffapp"),
        ApplicationData("axes femme", "com.axesfemme.axesfemmeapp"),
        ApplicationData("靴専門店　東京靴流通センター", "li.yapp.appB76130B0")
    )

    // 対応メモリスト(仮)
    private val informationMap = mapOf<String, InformationData>(
        "ハナマサプラス" to InformationData("肉の日 毎月29日大セール\n" +
                "QUICPay"),
        "ライフ" to InformationData("クレジットカード"),
        "まいばすけっと" to InformationData("WAONポイントカード\n" +
                "QUICPay"),
        "トモズ" to InformationData("チラシクーポン\n" +
                "トモズポイントカード"),
        "ウェルパーク" to InformationData("チラシクーポン\n" +
                "ウェルパークポイントカード\n" +
                "クレジットカード"),
        "くすりのダイイチ" to InformationData("ダイイチポイントカード\n" +
                "QUICPay"),
        "ドンキ" to InformationData("QUICPay"),
        "イオン" to InformationData("お客様感謝デー 20日・30日5％オフ\n" +
                "WAONポイントカード\n" +
                "QUICPay"),
        "PARCO" to InformationData("LINE Pay(一部店舗)"),
        "ファミマ" to InformationData("QUICPay"),
        "セブイレ" to InformationData("QUICPay"),
        "サークルKサンクス" to InformationData("QUICPay"),
        "ミニストップ" to InformationData("WAONポイントカード\n" +
                "QUICPay"),
        "NewDays" to InformationData("カウンターコーヒースタンプカード\n" +
                "クレジットカード"),
        "ビックカメラ" to InformationData("QUICPay"),
        "ヨドバシカメラ" to InformationData("QUICPay"),
        "ソフマップ" to InformationData("QUICPay"),
        "アニメイト" to InformationData("現金"),
        "らしんばん" to InformationData("らしんばんメンバーズカード\n" +
                "現金"),
        "K-BOOKS" to InformationData("K-BOOKSポイントカード\n" +
                "クレジットカード"),
        "ゲーマーズ" to InformationData("ゲーマーズカード\n" +
                "クレジットカード"),
        "とらのあな" to InformationData("QUICPay"),
        "メディアライン" to InformationData("QUICPay"),
        "ブックオフ" to InformationData("クレジットカード"),
        "タワーレコード" to InformationData("クレジットカード"),
        "アクシーズ ファム" to InformationData("クレジットカード"),
        "東京靴流通センター" to InformationData("クレジットカード"),
        "LOFT" to InformationData("QUICPay"),
        "TSUTAYA" to InformationData("QUICPay")
    )

    fun init(appContext: Context) {
        context = appContext
    }

    fun getUseCaseList(): Array<UseCaseData> {
        return useCaseList
    }

    fun getApplicationList(): Array<ApplicationData> {
        return applicationList
    }

    fun getInformation(titleName: String): String {
        return informationMap[titleName]?.memo ?: ""
    }

    fun getAppIntent(packageName: String): Intent? {
        var intent = context.getPackageManager().getLaunchIntentForPackage(packageName)
        return intent
    }

    fun getStoreIntent(packageName: String): Intent {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("market://details?id=$packageName"))
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
}