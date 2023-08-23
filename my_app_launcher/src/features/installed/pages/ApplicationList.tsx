import { Button, Linking, StyleSheet, Text, View } from 'react-native';

import {
  installedPackages,
  launchForPackageName,
  hello,
} from '../../../../modules/application-image';
import { WebView } from '../../../../modules/expo-web-view';

export default function ApplicationList() {
  return <WebView style={{ flex: 1, backgroundColor: 'blue' }} />;
  // return (
  //   <View style={styles.container}>
  //     <Text>ApplicationList</Text>
  //     <Button
  //       onPress={async () => {
  //         // const samplePackageName = 'com.kouzoh.mercari';
  //         // // これでアプリは開ける
  //         // launchForPackageName(samplePackageName);
  //         // これでストアも開ける
  //         // Linking.openURL('market://details?id=' + samplePackageName);
  //         const apps = await installedPackages();
  //         console.log(apps);
  //       }}
  //       title='button'
  //       color='#841584'
  //     />
  //     <WebView style={{ flex: 1, backgroundColor: 'purple' }} />
  //   </View>
  // );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
