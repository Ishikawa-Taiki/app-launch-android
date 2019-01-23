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
        "東京靴流通センター" to ApplicationItem("靴専門店　東京靴流通センター", "li.yapp.appB76130B0"),
        "ヘルスケア" to ApplicationItem("ヘルスケア手帳　【新アプリ】", "com.HealthcareNote"),
        "楽天ポイント" to ApplicationItem("楽天ポイントクラブ – 楽天ポイント管理アプリ", "jp.co.rakuten.pointclub.android"),
        "BanBan" to ApplicationItem("カラオケBanBan公式アプリ", "mobi.ban_ap.banban"),
        "ジャンカラ" to ApplicationItem("カラオケ　ジャンカラ（ジャンボカラオケ広場）", "jp.ne.jankara"),
        "マクドナルド" to ApplicationItem("マクドナルド - McDonald's Japan", "jp.co.mcdonalds.android"),
        "ケンタッキー" to ApplicationItem("ケンタッキーフライドチキン公式アプリ", "jp.dreambrain.adiorama"),
        "食べログ" to ApplicationItem("食べログ お店探し・予約アプリ - ランキングとグルメな人の口コミから飲食店検索", "com.kakaku.tabelog"),
        "吉野家" to ApplicationItem("吉野家公式アプリ　〜スマホ歩数計連動型クーポンアプリ〜", "com.yoshinoya.android.yoshinoya_official"),
        "丸亀製麺" to ApplicationItem("丸亀製麺", "com.toridoll.marugame.android")
    )

    // 対応ショップリスト
    val shopMap = mapOf<String, GroupItem>(
        "ハナマサプラス" to GroupItem(
            "ハナマサプラス", arrayOf(
                InformationItem("お得情報︰肉の日 毎月29日大セール"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ライフ" to GroupItem(
            "ライフ", arrayOf(
                applicationMap["ライフ"],
                applicationMap["Ponta"],
                applicationMap["dポイント"],
                InformationItem("クーポン︰ライフ公式アプリ(アプリ)"),
                InformationItem("ポイントカード︰Pontaカード(アプリ)/dポイント(アプリ)/ライフ公式アプリ(アプリ・チャージ不可)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "まいばすけっと" to GroupItem(
            "まいばすけっと", arrayOf(
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
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
                InformationItem("クーポン︰チラシクーポン/LINE(アプリ)/トクバイ(アプリ)"),
                InformationItem("ポイントカード︰トモズポイントカード＆Pontaカード(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/PayPay"),
                END
            ).filterNotNull()
        ),
        "ウェルパーク" to GroupItem(
            "ウェルパーク", arrayOf(
                applicationMap["LINE"],
                InformationItem("クーポン︰チラシクーポン/LINE(アプリ)"),
                InformationItem("ポイントカード︰ウェルパークポイントカード"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "くすりのダイイチ" to GroupItem(
            "くすりのダイイチ", arrayOf(
                InformationItem("ポイントカード︰ダイイチポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ドンキ" to GroupItem(
            "ドンキ", arrayOf(
                applicationMap["LINE"],
                applicationMap["majica"],
                InformationItem("クーポン︰LINE(アプリ)/majica(アプリ・券売機発券)"),
                InformationItem("ポイントカード︰majica(アプリ・チャージしない)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "イオン" to GroupItem(
            "イオン", arrayOf(
                applicationMap["イオン"],
                InformationItem("お得情報︰お客様感謝デー 20日・30日5％オフ"),
                InformationItem("クーポン︰イオンお買物(アプリ)"),
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "PARCO" to GroupItem(
            "PARCO", arrayOf(
                applicationMap["Origami"],
                applicationMap["LINE"],
                InformationItem("支払い方法︰OrigamiPay/LINE Pay(一部店舗)"),
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
                InformationItem("クーポン︰ローソン(アプリ)"),
                InformationItem("ポイントカード︰Pontaカード(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/OrigamiPay"),
                END
            ).filterNotNull()
        ),
        "ファミマ" to GroupItem(
            "ファミマ", arrayOf(
                applicationMap["Tポイント"],
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["PayPay"],
                InformationItem("ポイントカード︰Tポイント(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/PayPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "セブイレ" to GroupItem(
            "セブイレ", arrayOf(
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "サークルKサンクス" to GroupItem(
            "サークルKサンクス", arrayOf(
                applicationMap["Tポイント"],
                InformationItem("ポイントカード︰Tポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ミニストップ" to GroupItem(
            "ミニストップ", arrayOf(
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["PayPay"],
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/PayPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "NewDays" to GroupItem(
            "NewDays", arrayOf(
                InformationItem("ポイントカード︰カウンターコーヒースタンプカード"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "ローソンストア100" to GroupItem(
            "ローソンストア100", arrayOf(
                applicationMap["Ponta"],
                applicationMap["LINE"],
                applicationMap["楽天ペイ"],
                applicationMap["Origami"],
                InformationItem("ポイントカード︰Pontaカード(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/OrigamiPay"),
                END
            ).filterNotNull()
        ),
        "ビックカメラ" to GroupItem(
            "ビックカメラ", arrayOf(
                applicationMap["ビックカメラ"],
                applicationMap["LINE"],
                applicationMap["PayPay"],
                InformationItem("クーポン︰メットライフクラブ"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("ポイントカード︰ビックカメラ(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/PayPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "ヨドバシカメラ" to GroupItem(
            "ヨドバシカメラ", arrayOf(
                applicationMap["ヨドバシ"],
                InformationItem("ポイントカード︰ヨドバシゴールドポイントカード(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ソフマップ" to GroupItem(
            "ソフマップ", arrayOf(
                applicationMap["ビックカメラ"],
                applicationMap["LINE"],
                applicationMap["PayPay"],
                InformationItem("ポイントカード︰ビックカメラ(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/PayPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "アニメイト" to GroupItem(
            "アニメイト", arrayOf(
                applicationMap["アニメイト"],
                InformationItem("ポイントカード︰アニメイト(アプリ)"),
                InformationItem("支払い方法︰現金"),
                END
            ).filterNotNull()
        ),
        "らしんばん" to GroupItem(
            "らしんばん", arrayOf(
                InformationItem("ポイントカード︰らしんばんメンバーズカード"),
                InformationItem("支払い方法︰現金"),
                END
            ).filterNotNull()
        ),
        "K-BOOKS" to GroupItem(
            "K-BOOKS", arrayOf(
                InformationItem("ポイントカード︰K-BOOKSポイントカード"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "ゲーマーズ" to GroupItem(
            "ゲーマーズ", arrayOf(
                InformationItem("ポイントカード︰ゲーマーズカード"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "とらのあな" to GroupItem(
            "とらのあな", arrayOf(
                applicationMap["Origami"],
                applicationMap["PayPay"],
                InformationItem("支払い方法︰OrigamiPay/PayPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "メディアライン" to GroupItem(
            "メディアライン", arrayOf(
                applicationMap["dポイント"],
                InformationItem("ポイントカード︰dポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ジュンク堂書店" to GroupItem(
            "ジュンク堂書店", arrayOf(
                applicationMap["Ponta"],
                applicationMap["楽天ペイ"],
                InformationItem("ポイントカード︰Pontaカード(アプリ)"),
                InformationItem("支払い方法︰楽天ペイ"),
                END
            ).filterNotNull()
        ),
        "ブックオフ" to GroupItem(
            "ブックオフ", arrayOf(
                applicationMap["BOOKOFF"],
                InformationItem("クーポン︰ブックオフ(アプリ)"),
                InformationItem("ポイントカード︰ブックオフ(アプリ)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "タワーレコード" to GroupItem(
            "タワーレコード", arrayOf(
                applicationMap["dポイント"],
                InformationItem("クーポン︰dポイントクラブ(アプリ)"),
                InformationItem("ポイントカード︰dポイント(アプリ)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "アクシーズ ファム" to GroupItem(
            "アクシーズ ファム", arrayOf(
                applicationMap["axes femme"],
                InformationItem("ポイントカード︰axes femme(アプリ)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "ジーンズメイト" to GroupItem(
            "ジーンズメイト", arrayOf(
                applicationMap["Origami"],
                InformationItem("支払い方法︰OrigamiPay"),
                END
            ).filterNotNull()
        ),
        "東京靴流通センター" to GroupItem(
            "東京靴流通センター", arrayOf(
                applicationMap["東京靴流通センター"],
                InformationItem("クーポン︰靴専門店 東京靴流通センター(アプリ)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "LOFT" to GroupItem(
            "LOFT", arrayOf(
                applicationMap["Origami"],
                applicationMap["LINE"],
                InformationItem("支払い方法︰OrigamiPay/LINE Pay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "TSUTAYA" to GroupItem(
            "TSUTAYA", arrayOf(
                applicationMap["Tポイント"],
                InformationItem("ポイントカード︰Tポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ゲオ" to GroupItem(
            "ゲオ", arrayOf(
                applicationMap["Ponta"],
                applicationMap["LINE"],
                InformationItem("ポイントカード︰Pontaカード(アプリ)"),
                InformationItem("支払い方法︰LINE Pay"),
                END
            ).filterNotNull()
        ),
        "デイリーヤマザキ" to GroupItem(
            "デイリーヤマザキ", arrayOf(
                applicationMap["楽天ポイント"],
                InformationItem("ポイントカード︰楽天ポイントクラブ(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "しまむら" to GroupItem(
            "しまむら", arrayOf(
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "イオンシネマ" to GroupItem(
            "イオンシネマ", arrayOf(
                applicationMap["dポイント"],
                InformationItem("クーポン︰dポイント(アプリ)/メットライフクラブ"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("ポイントカード︰dポイント(アプリ)/WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "BanBan" to GroupItem(
            "BanBan", arrayOf(
                applicationMap["BanBan"],
                InformationItem("クーポン︰カラオケバンバン公式アプリ(アプリ)会員証＆クーポン"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ジャンカラ" to GroupItem(
            "ジャンカラ", arrayOf(
                applicationMap["ジャンカラ"],
                applicationMap["LINE"],
                InformationItem("クーポン︰カラオケジャンカラ(アプリ)会員証＆クーポン"),
                InformationItem("支払い方法︰LINE Pay"),
                END
            ).filterNotNull()
        ),
        "トーホーレジャープラザ" to GroupItem(
            "トーホーレジャープラザ", arrayOf(
                InformationItem("ポイントカード︰トーホーレジャープラザポイントカード"),
                END
            ).filterNotNull()
        ),
        "カフェきゃらふ" to GroupItem(
            "カフェきゃらふ", arrayOf(
                InformationItem("ポイントカード︰きゃらふスタンプカード"),
                InformationItem("支払い方法︰クレジットカード(3000円以上)"),
                END
            ).filterNotNull()
        ),
        "Cafe 犬猫人" to GroupItem(
            "Cafe 犬猫人", arrayOf(
                applicationMap["LINE"],
                InformationItem("お得情報︰はしご割"),
                InformationItem("ポイントカード︰犬猫人メンバーズカード＆犬猫人ポイントカード"),
                InformationItem("支払い方法︰LINE Pay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "Cafe 犬猫人2" to GroupItem(
            "Cafe 犬猫人2", arrayOf(
                applicationMap["LINE"],
                InformationItem("お得情報︰はしご割"),
                InformationItem("ポイントカード︰犬猫人メンバーズカード＆犬猫人2ポイントカード"),
                InformationItem("支払い方法︰LINE Pay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "トモズ 調剤薬局" to GroupItem(
            "トモズ 調剤薬局", arrayOf(
                applicationMap["ヘルスケア"],
                applicationMap["Ponta"],
                InformationItem("おくすり手帳︰ヘルスケア手帳(アプリ)"),
                InformationItem("ポイントカード︰トモズポイントカード/Pontaカード(アプリ)どちらか"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "鶏そば 壽(ことぶき)" to GroupItem(
            "鶏そば 壽(ことぶき)", arrayOf(
                InformationItem("クーポン︰Facebookいいね！画面で味玉無料"),
                InformationItem("LINK：", "https://m.facebook.com/torisoba.kotobuki"),
                END
            ).filterNotNull()
        ),
        "激アツ！ めん蔵" to GroupItem(
            "激アツ！ めん蔵", arrayOf(
                InformationItem("ポイントカード︰めん蔵ポイントカード"),
                END
            ).filterNotNull()
        ),
        "マクドナルド" to GroupItem(
            "マクドナルド", arrayOf(
                applicationMap["マクドナルド"],
                applicationMap["LINE"],
                InformationItem("クーポン︰マクドナルド(アプリ)/LINE(アプリ)"),
                InformationItem("ポイントカード︰マクドナルド(アプリ)楽天ポイントカード/dポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ケンタッキー" to GroupItem(
            "ケンタッキー", arrayOf(
                applicationMap["ケンタッキー"],
                applicationMap["Origami"],
                InformationItem("お得情報︰にわとりの日 毎月28日とりの日パック"),
                InformationItem("クーポン︰ケンタッキー(アプリ)"),
                InformationItem("ポイントカード︰ケンタッキー(アプリ・Ponta連携中)"),
                InformationItem("支払い方法︰OrigamiPay/QUICPay"),
                END
            ).filterNotNull()
        ),
        "大戸屋ごはん処" to GroupItem(
            "大戸屋ごはん処", arrayOf(
                applicationMap["LINE"],
                applicationMap["Ponta"],
                InformationItem("クーポン︰メットライフクラブ/LINE(アプリ)"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("ポイントカード︰Pontaカード(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ガスト" to GroupItem(
            "ガスト", arrayOf(
                applicationMap["LINE"],
                applicationMap["dポイント"],
                applicationMap["Tポイント"],
                applicationMap["楽天ペイ"],
                InformationItem("クーポン︰チラシクーポン/LINE(アプリ)/dポイント(アプリ)/メットライフクラブ"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("ポイントカード︰Tポイント(アプリ)"),
                InformationItem("支払い方法︰LINE Pay/楽天ペイ/QUICPay"),
                END
            ).filterNotNull()
        ),
        "三浦のハンバーグ" to GroupItem(
            "三浦のハンバーグ", arrayOf(
                InformationItem("クーポン︰食べログ"),
                InformationItem("LINK：", "https://tabelog.com/tokyo/A1305/A130501/13030030/"),
                InformationItem("ポイントカード︰三浦のハンバーグポイントカード"),
                END
            ).filterNotNull()
        ),
        "コメダ珈琲店" to GroupItem(
            "コメダ珈琲店", arrayOf(
                InformationItem("クーポン︰メットライフクラブ(東武練馬店×)"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "吉野家" to GroupItem(
            "吉野家", arrayOf(
                applicationMap["吉野家"],
                applicationMap["Origami"],
                InformationItem("クーポン︰吉野家(アプリ)"),
                InformationItem("ポイントカード︰Tポイントカード(リアルカードのみ)"),
                InformationItem("支払い方法︰OrigamiPay"),
                END
            ).filterNotNull()
        ),
        "すき家" to GroupItem(
            "すき家", arrayOf(
                InformationItem("クーポン︰チラシクーポン"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "丸亀製麺" to GroupItem(
            "丸亀製麺", arrayOf(
                applicationMap["丸亀製麺"],
                InformationItem("お得情報︰丸亀製麺の日 毎月1日釜揚げうどん半額"),
                InformationItem("クーポン︰チラシクーポン/丸亀製麺(アプリ・携帯1台で1人1クーポンのみ)/映画半券サービス"),
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "くら寿司" to GroupItem(
            "くら寿司", arrayOf(
                applicationMap["楽天ポイント"],
                InformationItem("ポイントカード︰楽天ポイントクラブ(アプリ)"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "かっぱ寿司" to GroupItem(
            "かっぱ寿司", arrayOf(
                applicationMap["dポイント"],
                InformationItem("ポイントカード︰dポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "磯のがってん寿司" to GroupItem(
            "磯のがってん寿司", arrayOf(
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "CoCo壱番屋" to GroupItem(
            "CoCo壱番屋", arrayOf(
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ミトミトカレー" to GroupItem(
            "ミトミトカレー", arrayOf(
                InformationItem("クーポン︰チラシクーポン"),
                END
            ).filterNotNull()
        ),
        "ペッパーランチ" to GroupItem(
            "ペッパーランチ", arrayOf(
                applicationMap["楽天ポイント"],
                applicationMap["dポイント"],
                InformationItem("ポイントカード︰楽天ポイントクラブ(アプリ)/dポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "焼肉 安楽亭" to GroupItem(
            "焼肉 安楽亭", arrayOf(
                applicationMap["LINE"],
                InformationItem("クーポン︰サービス券/LINE(アプリ)/メットライフクラブ/食べログ"),
                InformationItem("LINK：", "https://sp.club-off.com/117/apps/top/fftop_main.cfm"),
                InformationItem("LINK：", "https://tabelog.com/tokyo/A1322/A132203/13021668/"),
                InformationItem("支払い方法︰クレジットカード"),
                END
            ).filterNotNull()
        ),
        "鳥さく" to GroupItem(
            "鳥さく", arrayOf(
                InformationItem("クーポン︰サービス券/映画半券サービス"),
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ドトールコーヒーショップ" to GroupItem(
            "ドトールコーヒーショップ", arrayOf(
                applicationMap["dポイント"],
                InformationItem("クーポン︰dポイント(アプリ)"),
                InformationItem("ポイントカード︰Tポイントカード(リアルカードのみ)"),
                END
            ).filterNotNull()
        ),
        "サンマルクカフェ" to GroupItem(
            "サンマルクカフェ", arrayOf(
                applicationMap["dポイント"],
                InformationItem("ポイントカード︰dポイント(アプリ)"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "スターバックスコーヒー" to GroupItem(
            "スターバックスコーヒー", arrayOf(
                applicationMap["LINE"],
                InformationItem("お得情報︰ドリップコーヒーのみ2杯目100円"),
                InformationItem("支払い方法︰LINE Pay(一部店舗)"),
                END
            ).filterNotNull()
        ),
        "ビアードパパ" to GroupItem(
            "ビアードパパ", arrayOf(
                InformationItem("ポイントカード︰ビアードパパポイントカード"),
                END
            ).filterNotNull()
        ),
        "ミスタードーナツ" to GroupItem(
            "ミスタードーナツ", arrayOf(
                applicationMap["楽天ポイント"],
                InformationItem("ポイントカード︰楽天ポイントクラブ(アプリ)"),
                END
            ).filterNotNull()
        ),
        "くりこ庵" to GroupItem(
            "くりこ庵", arrayOf(
                InformationItem("ポイントカード︰くりこ庵スタンプカード"),
                END
            ).filterNotNull()
        ),
        "とくまるクリニック" to GroupItem(
            "とくまるクリニック", arrayOf(
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "カフェ・ド・クリエ" to GroupItem(
            "カフェ・ド・クリエ", arrayOf(
                InformationItem("お得情報︰2杯目100円"),
                END
            ).filterNotNull()
        ),
        "ディッパーダン" to GroupItem(
            "ディッパーダン", arrayOf(
                InformationItem("お得情報︰クレープの日 毎月9・19・29日クレープ全品300円"),
                InformationItem("クーポン︰公式サイト"),
                InformationItem("LINK：", "https://dipperdan.jp/coupon/"),
                END
            ).filterNotNull()
        ),
        "リンガーハット" to GroupItem(
            "リンガーハット", arrayOf(
                InformationItem("クーポン︰レシートクーポン、映画半券サービス"),
                InformationItem("ポイントカード︰WAONポイントカード"),
                InformationItem("支払い方法︰QUICPay"),
                END
            ).filterNotNull()
        ),
        "ザイカ" to GroupItem(
            "ザイカ", arrayOf(
                InformationItem("クーポン︰食べログ"),
                InformationItem("クーポン︰レシートクーポン、映画半券サービス"),
                InformationItem("LINK：", "https://tabelog.com/tokyo/A1322/A132203/13156453/"),
                END
            ).filterNotNull()
        ),
        "日高屋" to GroupItem(
            "日高屋", arrayOf(
                InformationItem("クーポン︰サービス券"),
                END
            ).filterNotNull()
        ),
        "ステーキハウス松木" to GroupItem(
            "ステーキハウス松木", arrayOf(
                InformationItem("クーポン︰サービス券/食べログ"),
                InformationItem("LINK：", "https://tabelog.com/tokyo/A1322/A132203/13054934"),
                END
            ).filterNotNull()
        )
    )

    // 対応グループリスト
    val groupMap = mapOf<String, GroupItem>(
        "スーパー" to GroupItem(
            "スーパー", arrayOf(
                shopMap["ハナマサプラス"],
                shopMap["イオン"],
                shopMap["ドンキ"],
                shopMap["ライフ"],
                shopMap["まいばすけっと"],
                END
            ).filterNotNull()
        ),
        "ドラッグストア" to GroupItem(
            "ドラッグストア", arrayOf(
                shopMap["トモズ"],
                shopMap["トモズ 調剤薬局"],
                shopMap["ウェルパーク"],
                shopMap["くすりのダイイチ"],
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
                shopMap["デイリーヤマザキ"],
                shopMap["NewDays"],
                shopMap["ローソンストア100"],
                END
            ).filterNotNull()
        ),
        "飲食店" to GroupItem(
            "飲食店", arrayOf(
                shopMap["マクドナルド"],
                shopMap["ケンタッキー"],
                shopMap["丸亀製麺"],
                shopMap["鳥さく"],
                shopMap["リンガーハット"],
                shopMap["焼肉 安楽亭"],
                shopMap["ミトミトカレー"],
                shopMap["ザイカ"],
                shopMap["CoCo壱番屋"],
                shopMap["激アツ！ めん蔵"],
                shopMap["日高屋"],
                shopMap["大戸屋ごはん処"],
                shopMap["ガスト"],
                shopMap["ステーキハウス松木"],
                shopMap["くら寿司"],
                shopMap["かっぱ寿司"],
                shopMap["磯のがってん寿司"],
                shopMap["鶏そば 壽(ことぶき)"],
                shopMap["三浦のハンバーグ"],
                shopMap["ペッパーランチ"],
                shopMap["吉野家"],
                shopMap["すき家"],
                END
            ).filterNotNull()
        ),
        "カフェ/軽食/スイーツ" to GroupItem(
            "カフェ/軽食/スイーツ", arrayOf(
                shopMap["コメダ珈琲店"],
                shopMap["スターバックスコーヒー"],
                shopMap["ドトールコーヒーショップ"],
                shopMap["サンマルクカフェ"],
                shopMap["カフェ・ド・クリエ"],
                shopMap["ビアードパパ"],
                shopMap["ミスタードーナツ"],
                shopMap["ディッパーダン"],
                shopMap["くりこ庵"],
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
        "パソコン/家電量販店" to GroupItem(
            "パソコン/家電量販店", arrayOf(
                shopMap["ビックカメラ"],
                shopMap["ソフマップ"],
                shopMap["ヨドバシカメラ"],
                END
            ).filterNotNull()
        ),
        "レジャー施設" to GroupItem(
            "レジャー施設", arrayOf(
                shopMap["イオンシネマ"],
                shopMap["BanBan"],
                shopMap["ジャンカラ"],
                shopMap["トーホーレジャープラザ"],
                shopMap["カフェきゃらふ"],
                shopMap["Cafe 犬猫人"],
                shopMap["Cafe 犬猫人2"],
                END
            ).filterNotNull()
        ),
        "本/CD/レンタル" to GroupItem(
            "本/CD/レンタル", arrayOf(
                shopMap["メディアライン"],
                shopMap["ジュンク堂書店"],
                shopMap["ブックオフ"],
                shopMap["TSUTAYA"],
                shopMap["ゲオ"],
                shopMap["タワーレコード"],
                END
            ).filterNotNull()
        ),
        "衣料品/靴" to GroupItem(
            "衣料品/靴", arrayOf(
                shopMap["しまむら"],
                shopMap["アクシーズ ファム"],
                shopMap["ジーンズメイト"],
                shopMap["東京靴流通センター"],
                END
            ).filterNotNull()
        ),
        "大型店舗" to GroupItem(
            "大型店舗", arrayOf(
                shopMap["イオン"],
                shopMap["ドンキ"],
                shopMap["LOFT"],
                shopMap["PARCO"],
                END
            ).filterNotNull()
        ),
        "病院" to GroupItem(
            "病院", arrayOf(
                shopMap["とくまるクリニック"],
                END
            ).filterNotNull()
        )
    )
}