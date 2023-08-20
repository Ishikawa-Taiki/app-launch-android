import { StyleSheet, Pressable, View, Text } from 'react-native';
import { ViewSpec } from '../../../const';

export type HeadlineProps = {
  onPress?: () => void;
  text: string;
};

export const Headline = (props: HeadlineProps) => (
  <Pressable style={styles.item} onPress={props.onPress}>
    <Text style={styles.title}>{props.text}</Text>
  </Pressable>
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
  },
});
