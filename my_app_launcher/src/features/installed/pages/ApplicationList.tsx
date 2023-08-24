import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, TextInput, View } from 'react-native';

import { Package, installedPackages } from '../../../../modules/expo-installed-application-view';
import { ApplicationCommon } from '../../../common/components/ApplicationCommon';
import { ViewSpec } from '../../../common/const';

export default function ApplicationList() {
  const [appPackages, setAppPackages] = useState([] as Package[]);
  const [searchText, onChangeSearchText] = useState('');
  useEffect(() => {
    installedPackages().then((packages) => {
      setAppPackages(packages.sort((a, b) => a.loadLabel.localeCompare(b.loadLabel)));
    });
  }, []);

  const listData = searchText
    ? appPackages.filter((appPackage) => appPackage.loadLabel.includes(searchText))
    : appPackages;

  return (
    <View style={styles.container}>
      <FlatList data={listData} renderItem={({ item }) => <Item appPackage={item} />} />
      <TextInput
        style={styles.searchBox}
        onChangeText={onChangeSearchText}
        value={searchText}
        placeholder={ViewSpec.TextDefinition.searchBoxPlaceholder}
      />
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
  searchBox: {
    backgroundColor: ViewSpec.Color.disableListBackground,
    margin: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
});
