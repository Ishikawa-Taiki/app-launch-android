package com.example.taiki.model

object ShoppingConstant {

    private val END: Item? = null

    // 対応アプリリスト
    val applicationMap = mapOf<String, ApplicationItem>(
        "ライフ" to ApplicationItem("ライフ 公式アプリ", "jp.co.lifecorp.android.app"),
        "Ponta" to ApplicationItem("Pontaカード(公式)", "jp.ponta.myponta"),
        "dポイント" to ApplicationItem("ｄポイントクラブ", "com.nttdocomo.android.dpoint"),
        "LINE" to ApplicationItem("LINE（ライン） - 無料通話・メールアプリ", "jp.naver.line.android"),
        "トクバイ" to ApplicationItem("トクバイ - 無料チラシアプリ／スーパー掲載数No.1", "jp.co.tokubai.android.bargain"),
        "楽天ペイ" to ApplicationItem("楽天ペイ –カード払いをアプリひとつで、楽天ポイントも使える", "jp.co.rakuten.pay"),
        "PayPay" to ApplicationItem("PayPay-QRコード・バーコードで支払うスマホアプリ", "jp.ne.paypay.android.app"),
        "majica" to ApplicationItem("majica～ドン・キホーテグループの電子マネー公式アプリ～", "com.donki.majica"),
        "イオン" to ApplicationItem("イオンお買物", "jp.aeonretail.aeon_okaimono"),
        "Origami" to ApplicationItem("Origami スマホ決済アプリ", "co.origami.android"),
        "ローソン" to ApplicationItem("ローソン", "jp.co.lawson.android"),
        "Tポイント" to ApplicationItem("Tポイント", "jp.co.ccc.Tsite"),
        "ビックカメラ" to ApplicationItem("ビックカメラ", "com.biccamera.android.mobile"),
        "ヨドバシ" to ApplicationItem("ヨドバシゴールドポイントカード", "com.yodobashi.coupon"),
        "アニメイト" to ApplicationItem("アニメイトアプリ", "jp.co.animate.mobileApp"),
        "BOOKOFF" to ApplicationItem("BOOKOFF ブックオフ公式アプリ　ポイントが貯まる・使える", "jp.co.bookoff.bookoffapp"),
        "axes femme" to ApplicationItem("axes femme", "com.axesfemme.axesfemmeapp"),
        "東京靴流通センター" to ApplicationItem("靴専門店　東京靴流通センター", "li.yapp.appB76130B0")
    )

    // 対応支払い方法
    val paymentMap = mapOf<String, InformationItem>(
        "QUICPay" to InformationItem("QUICPay払い"),
        "カード" to InformationItem("クレジットカード払い"),
        "現金" to InformationItem("現金払い")
    )

    // 対応掲示物
    val pointMap = mapOf<String, InformationItem>(
        "WAON" to InformationItem("WAONポイントカード"),
        "チラシ" to InformationItem("チラシクーポン")
    )

    // 対応ショップリスト
    val shopMap = mapOf<String, GroupItem>(
        "ハナマサプラス" to GroupItem(
            "ハナマサプラス", arrayOf(
                applicationMap["ライフ"],
                InformationItem("肉の日 毎月29日大セール"),
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ライフ" to GroupItem(
            "ライフ", arrayOf(
                applicationMap["ライフ"],
                applicationMap["Ponta"],
                applicationMap["dポイント"],
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "まいばすけっと" to GroupItem(
            "まいばすけっと", arrayOf(
                pointMap["WAON"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "トモズ" to GroupItem(
            "トモズ", arrayOf(
                applicationMap["LINE"],
                applicationMap["トクバイ"],
                applicationMap["Ponta"],
                applicationMap["楽天ペイ"],
                applicationMap["PayPay"],
                pointMap["チラシ"],
                InformationItem(
                    "トモズポイントカード"
                ),
                END
            ).filterNotNull()
        ),
        "ウェルパーク" to GroupItem(
            "ウェルパーク", arrayOf(
                applicationMap["LINE"],
                pointMap["チラシ"],
                InformationItem(
                    "ウェルパークポイントカード"
                ),
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "くすりのダイイチ" to GroupItem(
            "くすりのダイイチ", arrayOf(
                InformationItem(
                    "ダイイチポイントカード"
                ),
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ドンキ" to GroupItem(
            "ドンキ", arrayOf(
                applicationMap["LINE"],
                applicationMap["majica"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "イオン" to GroupItem(
            "イオン", arrayOf(
                applicationMap["イオン"],
                InformationItem(
                    "お客様感謝デー 20日・30日5％オフ"
                ),
                pointMap["WAON"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "PARCO" to GroupItem(
            "PARCO", arrayOf(
                applicationMap["LINE"],
                applicationMap["Origami"],
                InformationItem("LINE Pay(一部店舗)"),
                END
            ).filterNotNull()
        ),
        "ローソン" to GroupItem(
            "ローソン", arrayOf(
                applicationMap["ローソン"],
                applicationMap["Ponta"],
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["Origami"],
                END
            ).filterNotNull()
        ),
        "ファミマ" to GroupItem(
            "ファミマ", arrayOf(
                applicationMap["Tポイント"],
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["PayPay"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "セブイレ" to GroupItem(
            "セブイレ", arrayOf(
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "サークルKサンクス" to GroupItem(
            "サークルKサンクス", arrayOf(
                applicationMap["Tポイント"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ミニストップ" to GroupItem(
            "ミニストップ", arrayOf(
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["PayPay"],
                pointMap["WAON"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "NewDays" to GroupItem(
            "NewDays", arrayOf(
                InformationItem(
                    "カウンターコーヒースタンプカード"
                ),
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "ローソンストア100" to GroupItem(
            "ローソンストア100", arrayOf(
                applicationMap["Ponta"],
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["Origami"],
                END
            ).filterNotNull()
        ),
        "ビックカメラ" to GroupItem(
            "ビックカメラ", arrayOf(
                applicationMap["ビックカメラ"],
                applicationMap["LINE"],
                applicationMap["PayPay"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ヨドバシカメラ" to GroupItem(
            "ヨドバシカメラ", arrayOf(
                applicationMap["ヨドバシ"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ソフマップ" to GroupItem(
            "ソフマップ", arrayOf(
                applicationMap["ビックカメラ"],
                applicationMap["LINE"],
                applicationMap["PayPay"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "アニメイト" to GroupItem(
            "アニメイト", arrayOf(
                applicationMap["アニメイト"],
                paymentMap["現金"],
                END
            ).filterNotNull()
        ),
        "らしんばん" to GroupItem(
            "らしんばん", arrayOf(
                InformationItem(
                    "らしんばんメンバーズカード"
                ),
                paymentMap["現金"],
                END
            ).filterNotNull()
        ),
        "K-BOOKS" to GroupItem(
            "K-BOOKS", arrayOf(
                InformationItem(
                    "K-BOOKSポイントカード"
                ),
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "ゲーマーズ" to GroupItem(
            "ゲーマーズ", arrayOf(
                InformationItem(
                    "ゲーマーズカード"
                ),
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "とらのあな" to GroupItem(
            "とらのあな", arrayOf(
                applicationMap["Origami"],
                applicationMap["PayPay"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "メディアライン" to GroupItem(
            "メディアライン", arrayOf(
                applicationMap["dポイント"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ジュンク堂書店" to GroupItem(
            "ジュンク堂書店", arrayOf(
                applicationMap["Ponta"],
                applicationMap["楽天ペイ"],
                END
            ).filterNotNull()
        ),
        "ブックオフ" to GroupItem(
            "ブックオフ", arrayOf(
                applicationMap["BOOKOFF"],
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "タワーレコード" to GroupItem(
            "タワーレコード", arrayOf(
                applicationMap["dポイント"],
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "アクシーズ ファム" to GroupItem(
            "アクシーズ ファム", arrayOf(
                applicationMap["axes femme"],
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "ジーンズメイト" to GroupItem(
            "ジーンズメイト", arrayOf(
                applicationMap["Origami"]
            ).filterNotNull()
        ),
        "東京靴流通センター" to GroupItem(
            "東京靴流通センター", arrayOf(
                applicationMap["東京靴流通センター"],
                paymentMap["カード"],
                END
            ).filterNotNull()
        ),
        "LOFT" to GroupItem(
            "LOFT", arrayOf(
                applicationMap["LINE"],
                applicationMap["Origami"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "TSUTAYA" to GroupItem(
            "TSUTAYA", arrayOf(
                applicationMap["Tポイント"],
                paymentMap["QUICPay"],
                END
            ).filterNotNull()
        ),
        "ゲオ" to GroupItem(
            "ゲオ", arrayOf(
                applicationMap["Ponta"],
                applicationMap["LINE"],
                END
            ).filterNotNull()
        )
    )

    // 対応グループリスト
    val groupMap = mapOf<String, GroupItem>(
        "スーパー" to GroupItem(
            "スーパー", arrayOf(
                shopMap["ハナマサプラス"],
                shopMap["ライフ"],
                shopMap["まいばすけっと"],
                END
            ).filterNotNull()
        ),
        "ドラッグストア" to GroupItem(
            "ドラッグストア", arrayOf(
                shopMap["トモズ"],
                shopMap["ウェルパーク"],
                shopMap["くすりのダイイチ"],
                END
            ).filterNotNull()
        ),
        "ディスカウントストア" to GroupItem(
            "ディスカウントストア", arrayOf(
                shopMap["ドンキ"],
                END
            ).filterNotNull()
        ),
        "ショッピングモール" to GroupItem(
            "ショッピングモール", arrayOf(
                shopMap["イオン"],
                shopMap["PARCO"],
                END
            ).filterNotNull()
        ),
        "コンビニ" to GroupItem(
            "コンビニ", arrayOf(
                shopMap["ローソン"],
                shopMap["ファミマ"],
                shopMap["セブイレ"],
                shopMap["サークルKサンクス"],
                shopMap["ミニストップ"],
                shopMap["NewDays"],
                shopMap["ローソンストア100"],
                END
            ).filterNotNull()
        ),
        "家電量販店" to GroupItem(
            "家電量販店", arrayOf(
                shopMap["ビックカメラ"],
                shopMap["ヨドバシカメラ"],
                END
            ).filterNotNull()
        ),
        "パソコンショップ" to GroupItem(
            "パソコンショップ", arrayOf(
                shopMap["ソフマップ"],
                END
            ).filterNotNull()
        ),
        "ホビーショップ" to GroupItem(
            "ホビーショップ", arrayOf(
                shopMap["アニメイト"],
                shopMap["らしんばん"],
                shopMap["K-BOOKS"],
                shopMap["ゲーマーズ"],
                shopMap["とらのあな"],
                END
            ).filterNotNull()
        ),
        "本屋" to GroupItem(
            "本屋", arrayOf(
                shopMap["メディアライン"],
                shopMap["ジュンク堂書店"],
                END
            ).filterNotNull()
        ),
        "古本屋" to GroupItem(
            "古本屋", arrayOf(
                shopMap["ブックオフ"],
                END
            ).filterNotNull()
        ),
        "CDショップ" to GroupItem(
            "CDショップ", arrayOf(
                shopMap["タワーレコード"],
                END
            ).filterNotNull()
        ),
        "衣料品店" to GroupItem(
            "衣料品店", arrayOf(
                shopMap["アクシーズ ファム"],
                shopMap["ジーンズメイト"],
                END
            ).filterNotNull()
        ),
        "靴屋" to GroupItem(
            "靴屋", arrayOf(
                shopMap["東京靴流通センター"],
                END
            ).filterNotNull()
        ),
        "雑貨店" to GroupItem(
            "雑貨店", arrayOf(
                shopMap["LOFT"],
                END
            ).filterNotNull()
        ),
        "レンタルショップ" to GroupItem(
            "レンタルショップ", arrayOf(
                shopMap["TSUTAYA"],
                shopMap["ゲオ"],
                END
            ).filterNotNull()
        )
    )
}