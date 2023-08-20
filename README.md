# app-launch-android

個人用です

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

## Expo 管理画面

TODO: Android キーストアは適当に自動生成した。
見直した方が良さそうならどこかで。

https://expo.dev/accounts/ishikawa-taiki/projects/myAppLauncher
