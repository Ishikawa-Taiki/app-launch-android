import { StyleSheet, Pressable, Text, Linking } from 'react-native';

import {
  InstalledApplicationView,
  launchForPackageName,
} from '../../../../modules/expo-installed-application-view';
import { ViewSpec } from '../../../common/const';
import { useAppSelector } from '../../../common/hooks';
import { selectApplicationsByShortName } from '../selector';

export type ApplicationProps = {
  shortName: string;
};

export const Application = (props: ApplicationProps) => {
  const item = useAppSelector((state) => selectApplicationsByShortName(state, props.shortName));
  const packageName = item?.packageName ?? '';
  return (
    <Pressable
      style={styles.item}
      onPress={() => {
        launchForPackageName(packageName).catch((_e: any) => {
          Linking.openURL('market://details?id=' + packageName);
        });
      }}
    >
      <InstalledApplicationView packageName={packageName} style={styles.icon} />
      <Text style={styles.title}>{item?.shortName}</Text>
    </Pressable>
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
