import { StyleSheet, Pressable, View, Text } from 'react-native';
import { ViewSpec } from '../../../common/const';
import FontAwesome from '@expo/vector-icons/FontAwesome';
import FontAwesomeIcon from '../../../common/icons';

export type DirectoryProps = {
  onPress?: () => void;
  title: string;
};

export const Directory = (props: DirectoryProps) => (
  <Pressable style={styles.item} onPress={props.onPress}>
    <FontAwesomeIcon
      iconName='folder-open'
      size={ViewSpec.ImageSize.listIcon}
      color={ViewSpec.Color.directoryIcon}
    />
    <Text style={styles.title}>{props.title}</Text>
  </Pressable>
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
    marginLeft: ViewSpec.Margin.imageText,
    fontSize: ViewSpec.FontSize.listItem,
  },
});
