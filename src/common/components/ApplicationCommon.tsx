import * as Clipboard from 'expo-clipboard';
import { StyleSheet, Text, Linking } from 'react-native';

import { AppPressable } from './AppPressable';
import {
  InstalledApplicationView,
  launchForPackageName,
} from '../../../modules/expo-installed-application-view';
import { ViewSpec } from '../const';

export type ApplicationCommonProps = {
  shortName: string;
  packageName: string;
};

export const ApplicationCommon = (props: ApplicationCommonProps) => {
  const packageName = props.packageName;
  const shortName = props.shortName;
  return (
    <AppPressable
      style={styles.item}
      onPress={() => {
        launchForPackageName(packageName).catch((_e: any) => {
          Linking.openURL('market://details?id=' + packageName);
        });
      }}
      onLongPress={() => {
        Clipboard.setStringAsync(shortName + '=' + packageName);
      }}
    >
      <InstalledApplicationView packageName={packageName} style={styles.icon} />
      <Text style={styles.title}>{shortName}</Text>
    </AppPressable>
  );
};

const styles = StyleSheet.create({
  item: {
    backgroundColor: ViewSpec.Color.listBackground,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon + ViewSpec.Margin.listItem * 2,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  icon: {
    width: ViewSpec.ImageSize.listIcon,
    height: ViewSpec.ImageSize.listIcon,
  },
  title: {
    marginLeft: ViewSpec.Margin.imageText,
    fontSize: ViewSpec.FontSize.listItem,
  },
});
