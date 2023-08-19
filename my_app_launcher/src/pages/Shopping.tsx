import { Button, FlatList, Linking, Pressable, StyleSheet, Text, View } from 'react-native';
import React, { useEffect, useState } from 'react';
import { ShoppingService, fetchShoppingServices } from '../api/fetch-shopping-services';
import { Headline } from '../components/Headline';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Application } from '../components/Application';
import { Link } from '../components/Link';

const testJson: ShoppingService[] = [{ "data": "スーパー", "parentName": "root", "type": "group" }, { "data": "ディスカウントストア/大型店舗", "parentName": "root", "type": "group" }, { "data": "ドラッグストア", "parentName": "root", "type": "group" }, { "data": "飲食店", "parentName": "root", "type": "group" }, { "data": "カフェ/軽食/スイーツ", "parentName": "root", "type": "group" }, { "data": "100円ショップ", "parentName": "root", "type": "group" }, { "data": "コンビニ", "parentName": "root", "type": "group" }, { "data": "雑貨/ホームセンター", "parentName": "root", "type": "group" }, { "data": "本/CD/レンタル", "parentName": "root", "type": "group" }, { "data": "パソコン/家電量販店", "parentName": "root", "type": "group" }, { "data": "ファッション", "parentName": "root", "type": "group" }, { "data": "子供", "parentName": "root", "type": "group" }, { "data": "ホビーショップ", "parentName": "root", "type": "group" }, { "data": "レジャー施設", "parentName": "root", "type": "group" }, { "data": "コインランドリー/クリーニング", "parentName": "root", "type": "group" }, { "data": "デリバリー", "parentName": "root", "type": "group" }, { "data": "ネットショッピング", "parentName": "root", "type": "group" }, { "data": "Listonic", "parentName": "root", "type": "application" }, { "data": "電卓", "parentName": "root", "type": "application" }, { "data": "トクバイ", "parentName": "root", "type": "application" }, { "data": "お財布管理", "parentName": "root", "type": "group" }, { "data": "支払い方法", "parentName": "アコレ", "type": "title-text" }, { "data": "QUICPay(Tカードプライム)", "parentName": "アコレ", "type": "text" }, { "data": "クレジットカード(Tカードプライム)", "parentName": "アコレ", "type": "text" }, { "data": "Suica(ビックカメラSuica)", "parentName": "アコレ", "type": "text" }, { "data": "iD", "parentName": "アコレ", "type": "text" }, { "data": "チラシ", "parentName": "カスミ", "type": "title-text" }, { "data": "トクバイ", "parentName": "カスミ", "type": "application" }, { "data": "お得情報", "parentName": "カスミ", "type": "title-text" }, { "data": "", "parentName": "", "type": "" }, { "data": "毎週土・日曜日限定5％オフクーポン(週水・金曜日配布10％オフクーポンと併用可)", "parentName": "カスミ", "type": "text" }, { "data": "雨の日限定5%オフクーポン プロモーションコードame557入力またはコード読込(毎週水・金曜日配布10％オフクーポン＆毎週土・日曜日限定5％オフクーポンと併用可)", "parentName": "カスミ", "type": "text" }, { "data": "ポイントカード", "parentName": "カスミ", "type": "title-text" }, { "data": "イグニカポイント500から利用可能", "parentName": "カスミ", "type": "text" }, { "data": "Scan&Go", "parentName": "カスミ", "type": "application" }, { "data": "クーポン", "parentName": "カスミ", "type": "title-text" }, { "data": "Scan&Go", "parentName": "カスミ", "type": "application" }];

export default function Shopping({ navigation }) {
	const [data, setData] = useState<ShoppingService[]>([]);
	useEffect(() => { 
		// console.log(JSON.stringify(testJson));
		setData(testJson);
		// fetchShoppingServices().then(setData);
	 }, []);

	return (
		<FlatList
			data={data}
			renderItem={({ item }) => Item(item, navigation)}
		/>
	);
}

const Item = (itemData: ShoppingService, navigation) => {
	switch (itemData.type) {
		case "group":
			return (
				<Directory onPress={() =>navigation.push('ShoppingDetail')} title={itemData.data} />
			);
		case "title-text":
			return (
				<Headline text={itemData.data} />
				);
		case "text":
			return (
				<DisplayText text={itemData.data} />
			);
		case "application":
			return (
				<Application packageName={itemData.data} />
			);
		case "link":
			return (
				<Link onPress={() => Linking.openURL(itemData.data)} url={itemData.data} />
			);
		default:
			return null;
	}
}
