import { Button, StyleSheet, Text, View } from 'react-native';

export default function ApplicationList() {
  return (
    <View style={styles.container}>
      <Text>ApplicationList</Text>
      <Button onPress={() => {}} title='button' color='#841584' />
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
