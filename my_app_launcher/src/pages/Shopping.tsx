import { useEffect, useState } from 'react';
import { ShoppingService, fetchShoppingServices } from '../api/fetch-shopping-services';
import ShoppingServiceList from '../template/ShoppingServiceList';

export default function Shopping({ navigation }) {
  const [data, setData] = useState<ShoppingService[]>([]);
  useEffect(() => {
    // fetchShoppingServices().then(setData);
  }, []);

  return ShoppingServiceList(data, 'root', navigation);
}
