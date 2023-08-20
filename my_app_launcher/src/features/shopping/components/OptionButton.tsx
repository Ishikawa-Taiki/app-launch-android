import { StyleSheet, Pressable, View, Text, Button } from 'react-native';
import { ViewSpec } from '../../../common/const';

export type OptionButtonProps = {
  onPress?: () => void;
  title: string;
};

export const OptionButton = (props: OptionButtonProps) => (
  <Pressable style={styles.container} onPress={props.onPress}>
    <Text style={styles.title}>{props.title}</Text>
  </Pressable>
);

const styles = StyleSheet.create({
  container: {
    backgroundColor: ViewSpec.Color.optionButtonBackground,
    justifyContent: 'center',
    alignItems: 'center',
    margin: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  title: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.optionButtonTextColor,
    fontWeight: 'bold',
  },
});
