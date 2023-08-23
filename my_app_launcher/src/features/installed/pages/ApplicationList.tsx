import { Button, StyleSheet, Text, View } from 'react-native';

export default function ApplicationList() {
  // return (
  //   <ImageView packageName='jp.co.mcdonalds.android' style={{ flex: 1, backgroundColor: 'blue' }} />
  // );
  return (
    <View style={styles.container}>
      <Text>ApplicationList</Text>
      <Button
        onPress={async () => {
          // const samplePackageName = 'com.kouzoh.mercari';
          // // これでアプリは開ける
          // launchForPackageName(samplePackageName);
          // これでストアも開ける
          // Linking.openURL('market://details?id=' + samplePackageName);
          // const apps = await installedPackages();
          // console.log(apps);
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
