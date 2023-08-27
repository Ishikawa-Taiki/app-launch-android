import { useNavigation } from '@react-navigation/native';
import { StyleSheet, Text } from 'react-native';

import { AppPressable } from '../../../common/components/AppPressable';
import { ViewSpec } from '../../../common/const';
import FontAwesomeIcon from '../../../common/icons';

export type DirectoryProps = {
  title: string;
};

export const Directory = (props: DirectoryProps) => {
  const navigation = useNavigation() as any;
  return (
    <AppPressable
      style={styles.item}
      onPress={() => {
        const params = { filter: props.title };
        navigation.push('ShoppingDetail', params);
      }}
    >
      <FontAwesomeIcon
        iconName='folder'
        size={ViewSpec.ImageSize.listIcon}
        color={ViewSpec.Color.directoryIcon}
      />
      <Text style={styles.title}>{props.title}</Text>
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
  title: {
    marginLeft: ViewSpec.Margin.imageText,
    fontSize: ViewSpec.FontSize.listItem,
  },
});
