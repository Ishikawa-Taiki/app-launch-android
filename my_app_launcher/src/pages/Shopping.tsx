import { useEffect, useState } from 'react';
import { ShoppingService, fetchShoppingServices } from '../api/fetch-shopping-services';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { useAppDispatch } from '../app/hooks';
import { prepare } from '../features/shopping/slice';

export default function Shopping({ navigation }) {
  useEffect(() => {
    // fetchShoppingServices().then(setData);
  }, []);

  return <ShoppingServiceList filter={'root'} navigation={navigation} />;
}
