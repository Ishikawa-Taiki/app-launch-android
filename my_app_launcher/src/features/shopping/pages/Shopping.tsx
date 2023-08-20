import { useEffect } from 'react';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { useAppDispatch } from '../../../common/hooks';
import { prepare } from '../slice';

export default function Shopping({ navigation }) {
  const dispatch = useAppDispatch();
  useEffect(() => {
    dispatch(prepare());
  }, []);

  return <ShoppingServiceList filter={'root'} navigation={navigation} />;
}
