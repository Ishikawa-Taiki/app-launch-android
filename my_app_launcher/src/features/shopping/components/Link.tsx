import * as Clipboard from 'expo-clipboard';
import { StyleSheet, Text, Linking } from 'react-native';

import { AppPressable } from '../../../common/components/AppPressable';
import { ViewSpec } from '../../../common/const';

export type LinkProps = {
  url: string;
};

export const Link = (props: LinkProps) => (
  <AppPressable
    style={styles.item}
    onPress={() => Linking.openURL(props.url)}
    onLongPress={() => {
      Clipboard.setStringAsync(props.url);
    }}
  >
    <Text style={styles.title}>{props.url}</Text>
  </AppPressable>
);

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
  title: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.linkColor,
    textDecorationLine: 'underline',
    fontStyle: 'italic',
  },
});
