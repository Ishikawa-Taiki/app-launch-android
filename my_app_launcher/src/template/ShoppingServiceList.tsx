import { FlatList, Linking } from 'react-native';
import React from 'react';
import { ShoppingService } from '../api/fetch-shopping-services';
import { Headline } from '../components/Headline';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Application } from '../components/Application';
import { Link } from '../components/Link';

export default function ShoppingServiceList(items: ShoppingService[], filter: string, navigation) {
  const list = items.filter((value) => !!value.data && value.parentName === filter);

  return <FlatList data={list} renderItem={({ item }) => Item(items, item, navigation)} />;
}

const Item = (items: ShoppingService[], itemData: ShoppingService, navigation) => {
  switch (itemData.type) {
    case 'group':
      return (
        <Directory
          onPress={() => {
            const params = { items: items, filter: itemData.data };
            console.log(JSON.stringify(params));
            navigation.push('ShoppingDetail', params);
          }}
          title={itemData.data}
        />
      );
    case 'title-text':
      return <Headline text={itemData.data} />;
    case 'text':
      return <DisplayText text={itemData.data} />;
    case 'application':
      return <Application packageName={itemData.data} />;
    case 'link':
      return <Link onPress={() => Linking.openURL(itemData.data)} url={itemData.data} />;
    default:
      return null;
  }
};
