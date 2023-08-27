# app-launch-android

個人用です

app-launch-android：試作運用中の kotlin ネイティブベースのプロジェクト
my_app_launcher：本運用開始用の ReactNative(Expo)ベースのプロジェクト

# コマンド類のメモ

## バンドラ起動

yarn start

バンドラを立ち上げるコマンド
ネイティブモジュールを持っているので、--dev-client オプション付きで立ち上がるようにしている

## Android ビルド&実行(+自動バンドラ立ち上げ)

yarn dev-android

ネイティブモジュール含めたビルドが実行される
出来上がるバイナリは development のもの(バンドラ経由でスクリプトをダウンロードするやつ)
このコマンドなら Android Studio 立ち上げ不要だが、デバッグしたければ Android Studio の実行ボタン＆アタッチでも出来る
このコマンドは実行時に同時にバンドラも立ち上げてくれるため、個別でバンドラを立ち上げる必要はない

## Android バイナリ作成(EAS Build 利用)

yarn build-android-dev
yarn build-android-pre

叩くと、以下管理画面上のビルドジョブが動くのでそこからバイナリがダウンロードできるようになる
Android エミュレータ/デバイスの両方で利用可能
https://expo.dev/accounts/ishikawa-taiki/projects/myAppLauncher

前者で出来上がるバイナリは development のもの(バンドラ経由でスクリプトをダウンロードするやつ)
なので、PC 側でバンドラを立ち上げる必要がある
なお起動後のフォーム内にバンドラの IP アドレスを記載する必要があるが、フォーカスが当たっている状態で以下 adb コマンドを利用すると楽

adb shell input text "com.ressac.myapplauncher://expo-development-client/?url=http://192.168.11.7:8081"

後者で出来上がるバイナリは preview のもの(J パッケージ中に JS も組み込まれる)
なので、バンドラを立ち上げる必要はない(リリースしないならこれで通常運用可能)

現状はリリースしないアプリなので production 用のコマンドは用意していない＆未確認な状態

## ネイティブモジュール作成コマンド

yarn create-native-module

で質問に色々答えていく

ライブラリは
com.ressac.modules.パッケージ名

としておくことにしている

## lint

yarn lint

lint をかける
./src 配下のみを対象としており、App.tsx 等はかからないはず
現状適当に拾ってきたルールを適用してるだけで、prettier 含めてそこまでちゃんと見直しをしていない

# TODO

Expo 管理画面にて、Android キーストアは適当に自動生成した
見直した方が良さそうならどこかで
