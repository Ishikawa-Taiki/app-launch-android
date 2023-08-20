import { FlatList, Linking } from 'react-native';
import React, { useMemo } from 'react';
import { ShoppingService } from '../fetch-shopping-services';
import { Headline } from '../components/Headline';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Application } from '../components/Application';
import { Link } from '../components/Link';
import { useAppSelector } from '../../../common/hooks';
import { selectServicesByParentName } from '../slice';

export default function ShoppingServiceList(props: { filter: string; navigation: any }) {
  const list = useAppSelector((state) => selectServicesByParentName(state, props.filter));

  return <FlatList data={list} renderItem={({ item }) => Item(item, props.navigation)} />;
}

const Item = (itemData: ShoppingService, navigation) => {
  switch (itemData.type) {
    case 'group':
      return (
        <Directory
          onPress={() => {
            const params = { filter: itemData.data };
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
