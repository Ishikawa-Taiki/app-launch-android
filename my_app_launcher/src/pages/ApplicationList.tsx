import { Button, StyleSheet, Text, View } from 'react-native';
import { increment, selectCount } from '../features/shopping/slice';
import { useAppDispatch, useAppSelector } from '../app/hooks';

export default function ApplicationList({ navigation }) {
  const count = useAppSelector(selectCount);
  const dispatch = useAppDispatch();
  return (
    <View style={styles.container}>
      <Text>ApplicationList: {count} !!! </Text>
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
