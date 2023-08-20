import { FlatList, Linking } from 'react-native';
import React from 'react';
import { ShoppingService } from '../api/fetch-shopping-services';
import { Headline } from '../components/Headline';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Application } from '../components/Application';
import { Link } from '../components/Link';
import { useAppSelector } from '../../../common/hooks';
import { selectServicesByParentName } from '../selector';
import { useNavigation } from '@react-navigation/native';

export default function ShoppingServiceList(props: { filter: string }) {
  const list = useAppSelector((state) => selectServicesByParentName(state, props.filter));

  return <FlatList data={list} renderItem={({ item }) => <Item itemData={item} />} />;
}

const Item = (props: { itemData: ShoppingService }) => {
  const navigation = useNavigation();
  switch (props.itemData.type) {
    case 'group':
      return (
        <Directory
          onPress={() => {
            const params = { filter: props.itemData.data };
            navigation.push('ShoppingDetail', params);
          }}
          title={props.itemData.data}
        />
      );
    case 'title-text':
      return <Headline text={props.itemData.data} />;
    case 'text':
      return <DisplayText text={props.itemData.data} />;
    case 'application':
      return <Application shortName={props.itemData.data} />;
    case 'link':
      return (
        <Link onPress={() => Linking.openURL(props.itemData.data)} url={props.itemData.data} />
      );
    default:
      return null;
  }
};
