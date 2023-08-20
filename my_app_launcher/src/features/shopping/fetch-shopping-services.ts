import { requestWebAPI } from '../../app/api';

export type DataType =
  | 'group' // 子供をまとめるグループに使用する	ただの文字情報なのでなんでもOK
  | 'title-text' //見出しとして表示するテキストアイテムに使用する	ただの文字情報なのでなんでもOK
  | 'text' // 表示するだけのテキストアイテムに使用する	ただの文字情報なのでなんでもOK
  | 'application' // アプリケーションに使用する	AndroidApplications の shortNameを間違いなく指定すること
  | 'link'; // URLのリンクアイテムに使用する	ジャンプ可能なURLを間違いなく指定すること

export type ShoppingService = {
  data: string;
  parentName: string;
  type: DataType;
};

export async function fetchShoppingServices() {
  return requestWebAPI<ShoppingService[]>('exec?file=Services&sheet=shopping');
}
