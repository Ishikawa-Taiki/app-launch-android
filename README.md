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

## 開発用のモジュール作成コマンド

npx create-expo-module@latest --local

で質問に色々答えていく

ライブラリは
com.ressac.modules.パッケージ名

としておく

# 一時メモ後で消すかも

$ npx create-expo-module@latest --local expo-installed-application-view

The local module will be created in the modules directory in the root of your project. Learn more: https://expo.fyi/expo-module-local-autolinking.md

✔ What is the name of the local module? … expo-installed-application-view
✔ What is the native module name? … ExpoInstalledApplicationView
✔ What is the Android package name? … com.ressac.modules.installedapplication

✔ Downloaded module template from npm
✔ Created the module from template files

✅ Successfully created Expo module in modules/expo-installed-application-view

You can now import this module inside your application.
For example, you can add this line to your App.js or App.tsx file:
import { hello } from './modules/expo-installed-application-view';
