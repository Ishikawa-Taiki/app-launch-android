import { Pressable, PressableProps, PressableStateCallbackType, ViewStyle } from 'react-native';

import { ViewSpec } from '../const';

export type AppPressableProps = PressableProps;

export const AppPressable = (props: AppPressableProps) => {
  return (
    <Pressable
      {...props}
      style={({ pressed }: PressableStateCallbackType) => [
        { opacity: pressed ? ViewSpec.Operation.pressedOpacity : 1 },
        props.style as ViewStyle,
      ]}
      delayLongPress={ViewSpec.Operation.delayLongPress}
    />
  );
};
