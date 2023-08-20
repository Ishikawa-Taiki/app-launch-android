import { Button, StyleSheet, Text, View } from 'react-native';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { ShoppingService } from '../fetch-shopping-services';

export default function ShoppingDetail(props: { route: { params: any[] } }) {
  return <ShoppingServiceList filter={props.route.params.filter} />;
}
