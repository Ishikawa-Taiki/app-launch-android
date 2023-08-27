import { StyleSheet, View, Text } from 'react-native';

import { ViewSpec } from '../../../common/const';
import FontAwesomeIcon from '../../../common/icons';

export type DetailHeaderProps = {
  title: string;
};

export const DetailHeader = (props: DetailHeaderProps) => (
  <View style={styles.item}>
    <FontAwesomeIcon
      iconName='folder-open'
      size={ViewSpec.ImageSize.listIcon}
      color={ViewSpec.Color.navigateIcon}
    />
    <Text style={styles.title}>{props.title}</Text>
  </View>
);

const styles = StyleSheet.create({
  item: {
    backgroundColor: ViewSpec.Color.tabNavigatorBackground,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: ViewSpec.Margin.listItem,
    height: ViewSpec.ImageSize.listIcon + ViewSpec.Margin.listItem * 2,
    borderWidth: ViewSpec.BorderStyle.listBorderWidth,
    borderColor: ViewSpec.BorderStyle.listBorderColor,
  },
  title: {
    marginLeft: ViewSpec.Margin.imageText,
    fontSize: ViewSpec.FontSize.tabNavigatorText,
    color: ViewSpec.FontStyle.detailHeaderTextColor,
    fontWeight: 'bold',
  },
});
