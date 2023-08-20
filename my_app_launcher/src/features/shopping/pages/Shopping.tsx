import { useEffect } from 'react';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { useAppDispatch } from '../../../common/hooks';
import { prepare, update } from '../slice';
import { StyleSheet, View } from 'react-native';
import { OptionButton } from '../components/OptionButton';

export default function Shopping() {
  const dispatch = useAppDispatch();
  useEffect(() => {
    dispatch(prepare());
  }, []);

  return (
    <View style={styles.container}>
      <ShoppingServiceList filter={'root'} />
      <OptionButton
        title='再読み込み'
        onPress={() => {
          dispatch(update());
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
