import { Button, StyleSheet, Text, View } from 'react-native';
import { useSelector, useDispatch } from 'react-redux';
import { increment } from '../features/shopping/slice';

export default function ApplicationList({ navigation }) {
  const count = useSelector((state) => state.shopping.value);
  const dispatch = useDispatch();
  return (
    <View style={styles.container}>
      <Text>ApplicationList: {count}</Text>
      <Button
        onPress={() => {
          console.log('pressed!');
          dispatch(increment());
        }}
        title='button'
        color='#841584'
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
