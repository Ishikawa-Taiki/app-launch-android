import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, View } from 'react-native';

import { Package, installedPackages } from '../../../../modules/expo-installed-application-view';
import { ApplicationCommon } from '../../../common/components/ApplicationCommon';

export default function ApplicationList() {
  const [appPackages, setAppPackages] = useState([] as Package[]);
  useEffect(() => {
    installedPackages().then(setAppPackages);
  }, []);

  return (
    <View style={styles.container}>
      <FlatList data={appPackages} renderItem={({ item }) => <Item appPackage={item} />} />
    </View>
  );
}

const Item = (props: { appPackage: Package }) => {
  return (
    <ApplicationCommon
      packageName={props.appPackage.packageName}
      shortName={props.appPackage.loadLabel}
    />
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
