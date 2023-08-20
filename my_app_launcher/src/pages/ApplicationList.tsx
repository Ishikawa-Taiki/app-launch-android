import { Button, StyleSheet, Text, View } from 'react-native';
import { fetch } from '../features/shopping/slice';
import { useAppDispatch, useAppSelector } from '../app/hooks';

export default function ApplicationList({ navigation }) {
  const dispatch = useAppDispatch();
  return (
    <View style={styles.container}>
      <Text>ApplicationList</Text>
      <Button
        onPress={() => {
          console.log('pressed!');
          dispatch(fetch());
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
