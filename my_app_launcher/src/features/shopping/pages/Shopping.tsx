import { useEffect } from 'react';
import ShoppingServiceList from '../template/ShoppingServiceList';
import { useAppDispatch, useAppSelector } from '../../../common/hooks';
import { LoadingStatus, prepare, update } from '../slice';
import { ActivityIndicator, StyleSheet, View, Text } from 'react-native';
import { OptionButton } from '../components/OptionButton';
import { selectErrorStatus, selectLoadingStatus } from '../selector';
import { ViewSpec } from '../../../common/const';

export default function Shopping() {
  const dispatch = useAppDispatch();
  const status = useAppSelector(selectLoadingStatus);
  const error = useAppSelector(selectErrorStatus);
  useEffect(() => {
    dispatch(prepare());
  }, []);

  return (
    <View style={styles.container}>
      <ShoppingContents status={status} error={error} />
      <OptionButton
        title='再読み込み'
        onPress={() => {
          dispatch(update());
        }}
      />
    </View>
  );
}

const ShoppingContents = (props: { status: LoadingStatus; error: any }) => {
  switch (props.status) {
    case 'idle':
      return null;
    case 'loading':
      return (
        <View style={styles.loadingAndErrorContainer}>
          <ActivityIndicator size='large' />
        </View>
      );
    case 'failed':
      return (
        <View style={styles.loadingAndErrorContainer}>
          <Text style={styles.errorText}>エラー：{JSON.stringify(props.error)}</Text>
        </View>
      );
    case 'succeeded':
      return <ShoppingServiceList filter={'root'} />;
  }
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  loadingAndErrorContainer: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
    alignItems: 'center',
  },
  errorText: {
    fontSize: ViewSpec.FontSize.listItem,
    color: ViewSpec.FontStyle.errorTextColor,
  },
});
