import { StyleSheet, View, Text } from 'react-native';

import { ViewSpec } from '../../../common/const';

export type HeadlineProps = {
  text: string;
};

export const Headline = (props: HeadlineProps) => (
  <View style={styles.item}>
    <Text style={styles.title}>{props.text}</Text>
  </View>
);

const styles = StyleSheet.create({
  item: {
    backgroundColor: ViewSpec.Color.headlineBackground,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: ViewSpec.Margin.listItem,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  title: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.headlineTextColor,
    fontWeight: 'bold',
    minHeight: ViewSpec.FontStyle.headlineHeight,
    textAlignVertical: 'center',
  },
});
