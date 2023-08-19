import { Button, StyleSheet, Text, View } from 'react-native';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { ShoppingService } from '../api/fetch-shopping-services';

export default function ShoppingDetail(props) {
  return ShoppingServiceList(
    props.route.params.items as ShoppingService[],
    props.route.params.filter,
    props.navigation,
  );
}
