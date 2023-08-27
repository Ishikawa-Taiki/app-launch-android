import { useEffect, useState } from 'react';
import { FlatList, Pressable, StyleSheet, TextInput, View, Text } from 'react-native';

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
    ? appPackages.filter((appPackage) =>
        appPackage.loadLabel.toUpperCase().includes(searchText.toUpperCase()),
      )
    : appPackages;

  return (
    <View style={styles.container}>
      <FlatList data={listData} renderItem={({ item }) => <Item appPackage={item} />} />
      <View style={{ flexDirection: 'row' }}>
        <TextInput
          style={styles.searchBox}
          onChangeText={onChangeSearchText}
          value={searchText}
          placeholder={ViewSpec.TextDefinition.searchBoxPlaceholder}
        />
        <Pressable style={styles.clearButton} onPress={() => onChangeSearchText('')}>
          <Text style={styles.clearButtonText}>クリア</Text>
        </Pressable>
      </View>
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
    flex: 1,
    backgroundColor: ViewSpec.Color.disableListBackground,
    margin: ViewSpec.Margin.listItem,
    paddingLeft: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  clearButton: {
    backgroundColor: ViewSpec.Color.optionButtonBackground,
    justifyContent: 'center',
    alignItems: 'center',
    margin: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  clearButtonText: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.optionButtonTextColor,
    fontWeight: 'bold',
  },
});
