import { Button, StyleSheet, Text, View } from 'react-native';
import ApplicationImageModule from '../../../../modules/application-image/src/ApplicationImageModule';

export default function ApplicationList() {
  return (
    <View style={styles.container}>
      <Text>ApplicationList</Text>
      <Button
        onPress={() => {
          const value = ApplicationImageModule.hello();
          console.log(value);
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
