# app-launch-android

個人用です

app-launch-android：試作運用中の kotlin ネイティブベースのプロジェクト
my_app_launcher：本運用開始用の ReactNative(Expo)ベースのプロジェクト

# コマンド類のメモ

## 通常作業

### 普通のビルド

npx expo run:android

### 普通のバンドラ起動

npx expo start

### 開発者クライアントのバンドラ起動

npx expo start --dev-client

## EAS Build

### Android エミュレータ/デバイス の 開発者向け

eas build --profile development --platform android

叩くと、以下管理画面上のビルドジョブが動くのでそこからバイナリがダウンロードできる。
PC 側でバンドラは立ち上げる必要がある。

### Android エミュレータ/デバイス の プレビュー版

eas build --profile preview --platform android

こちらも叩くと、以下管理画面上のビルドジョブが動くのでそこからバイナリがダウンロードできる。
パッケージ中に JS も組み込まれるので、バンドラを立ち上げる必要はない。(リリースしないならこれで通常運用可能)

## Expo 管理画面

TODO: Android キーストアは適当に自動生成した。
見直した方が良さそうならどこかで。

https://expo.dev/accounts/ishikawa-taiki/projects/myAppLauncher

## 開発用のモジュール作成コマンド

npx create-expo-module@latest --local

で質問に色々答えていく

ライブラリは
com.ressac.modules.パッケージ名

としておく
