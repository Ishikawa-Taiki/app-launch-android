import { FlatList, Linking } from 'react-native';
import React, { useMemo } from 'react';
import { ShoppingService } from '../api/fetch-shopping-services';
import { Headline } from '../components/Headline';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Application } from '../components/Application';
import { Link } from '../components/Link';
import { useAppSelector } from '../app/hooks';
import { makeSelectServicesByParentName } from '../features/shopping/slice';

export default function ShoppingServiceList(props: { filter: string; navigation: any }) {
  console.log('filter!!!!:' + props.filter);
  const selectServicesByParentName = useMemo(makeSelectServicesByParentName, []);
  const list = useAppSelector((state) => {
    console.log('filter2!!!!:' + props.filter);
    return selectServicesByParentName(state, props.filter);
  });

  return <FlatList data={list} renderItem={({ item }) => Item(item, props.navigation)} />;
}

const Item = (itemData: ShoppingService, navigation) => {
  switch (itemData.type) {
    case 'group':
      return (
        <Directory
          onPress={() => {
            const params = { filter: itemData.data };
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
