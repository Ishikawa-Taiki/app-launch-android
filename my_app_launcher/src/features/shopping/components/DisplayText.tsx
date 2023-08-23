import { StyleSheet, View, Text } from 'react-native';

import { ViewSpec } from '../../../common/const';

export type DisplayTextProps = {
  text: string;
};

export const DisplayText = (props: DisplayTextProps) => (
  <View style={styles.item}>
    <Text style={styles.title}>{props.text}</Text>
  </View>
);

const styles = StyleSheet.create({
  item: {
    backgroundColor: ViewSpec.Color.disableListBackground,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: ViewSpec.Margin.listItem,
    minHeight: ViewSpec.ImageSize.listIcon + ViewSpec.Margin.listItem * 2,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  title: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.displayTextColor,
    fontStyle: 'italic',
  },
});
