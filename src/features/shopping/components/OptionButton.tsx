import { StyleSheet, Text } from 'react-native';

import { AppPressable } from '../../../common/components/AppPressable';
import { ViewSpec } from '../../../common/const';

export type OptionButtonProps = {
  onPress?: () => void;
  title: string;
};

export const OptionButton = (props: OptionButtonProps) => (
  <AppPressable style={styles.container} onPress={props.onPress}>
    <Text style={styles.title}>{props.title}</Text>
  </AppPressable>
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
