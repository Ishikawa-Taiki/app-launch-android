import React from 'react';
import { FlatList } from 'react-native';

import { useAppSelector } from '../../../common/hooks';
import { ShoppingService } from '../api/fetch-shopping-services';
import { Application } from '../components/Application';
import { Directory } from '../components/Directory';
import { DisplayText } from '../components/DisplayText';
import { Headline } from '../components/Headline';
import { Link } from '../components/Link';
import { selectServicesByParentName } from '../selector';

export default function ShoppingServiceList(props: { filter: string }) {
  const list = useAppSelector((state) => selectServicesByParentName(state, props.filter));

  return <FlatList data={list} renderItem={({ item }) => <Item itemData={item} />} />;
}

const Item = (props: { itemData: ShoppingService }) => {
  switch (props.itemData.type) {
    case 'group':
      return <Directory title={props.itemData.data} />;
    case 'title-text':
      return <Headline text={props.itemData.data} />;
    case 'text':
      return <DisplayText text={props.itemData.data} />;
    case 'application':
      return <Application shortName={props.itemData.data} />;
    case 'link':
      return <Link url={props.itemData.data} />;
    default:
      return null;
  }
};
