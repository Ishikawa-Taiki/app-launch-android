import { useRoute } from '@react-navigation/native';
import ShoppingServiceList from '../template/ShoppingServiceList';

export default function ShoppingDetail() {
  const route = useRoute() as { params: { filter: string } };
  return <ShoppingServiceList filter={route.params.filter} />;
}
