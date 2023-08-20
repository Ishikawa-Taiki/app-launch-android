import { useEffect } from 'react';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { useAppDispatch } from '../../../common/hooks';
import { prepare } from '../slice';

export default function Shopping() {
  const dispatch = useAppDispatch();
  useEffect(() => {
    dispatch(prepare());
  }, []);

  return <ShoppingServiceList filter={'root'} />;
}
