# app-launch-android

個人用
本運用開始用の ReactNative(Expo)ベースのプロジェクト
※ 試作運用中の kotlin ネイティブベースのプロジェクトは削除済みのため、必要に応じてログから確認すること

# バージョニング

セマンティックバージョニングをベースとするが、個人用のためざっくりで以下くらいの方針とする

メジャー：Expo等フレームワーク/ネイティブレベル/WebAPIでのAPI互換性が変化した時

マイナー：TS/JS上のみで機能追加等を行った時

パッチ　：不具合修正/微調整を行った時

# コマンド類のメモ

## 環境セットアップ(clone直後)

yarn install

で必要なモジュールを導入する

## バンドラ起動

yarn start

バンドラを立ち上げるコマンド
ネイティブモジュールを持っているので、--dev-client オプション付きで立ち上がるようにしている

## Android ビルド&実行(+自動バンドラ立ち上げ)

yarn android

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

# 自動ビルド(Github Actions)

.github/workflows/eas-build.yml によって制御されている

対応時の手順概要は以下の通り
https://docs.expo.dev/build/building-on-ci/

詳細手順としては、Expo 側で作成した個人用アクセストークンを
https://docs.expo.dev/accounts/programmatic-access/#personal-access-tokens

リポジトリのGithub Actions設定側のsecret値として入力している
https://docs.github.com/ja/actions/security-guides/encrypted-secrets#creating-encrypted-secrets-for-a-repository

そうするとリポジトリの所定の場所に配置した.ymlが設定を読み取り、ビルドをキックしてくれる

.yml ファイルの例としては、以下も参考になる
https://github.com/expo/expo-github-action#example-workflows

アクセストークンの値は再確認できないので、問題があったら一度無効化/再生成するようにする
https://expo.dev/accounts/ishikawa-taiki/settings/access-tokens
https://github.com/Ishikawa-Taiki/app-launch-android/settings/secrets/actions

# TODO

Expo 管理画面にて、Android キーストアは適当に自動生成した
見直した方が良さそうならどこかで
