import { useNavigation, useRoute } from '@react-navigation/native';
import { StyleSheet, View } from 'react-native';

import { DetailHeader } from '../components/DetailHeader';
import { OptionButton } from '../components/OptionButton';
import ShoppingServiceList from '../template/ShoppingServiceList';

export default function ShoppingDetail() {
  const route = useRoute() as { params: { filter: string } };
  const filter = route.params.filter;
  const navigation = useNavigation();
  return (
    <View style={styles.container}>
      <DetailHeader title={filter} />
      <ShoppingServiceList filter={filter} />
      <OptionButton title='戻る' onPress={navigation.goBack} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
