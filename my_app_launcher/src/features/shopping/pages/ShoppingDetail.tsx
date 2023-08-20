import { useNavigation, useRoute } from '@react-navigation/native';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { OptionButton } from '../components/OptionButton';
import { StyleSheet, View } from 'react-native';

export default function ShoppingDetail() {
  const route = useRoute() as { params: { filter: string } };
  const filter = route.params.filter;
  const navigation = useNavigation();
  return (
    <View style={styles.container}>
      <ShoppingServiceList filter={filter} />
      <OptionButton
        title={filter + '/ 戻る'}
        onPress={() => {
          navigation.goBack();
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
