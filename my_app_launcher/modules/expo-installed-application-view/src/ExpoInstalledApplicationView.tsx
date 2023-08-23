// import { requireNativeViewManager } from 'expo-modules-core';
// import * as React from 'react';

// import { ExpoInstalledApplicationViewProps } from './ExpoInstalledApplicationView.types';

// const NativeView: React.ComponentType<ExpoInstalledApplicationViewProps> =
//   requireNativeViewManager('ExpoInstalledApplicationView');

// export default function ExpoInstalledApplicationView(props: ExpoInstalledApplicationViewProps) {
//   return <NativeView {...props} />;
// }

import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from 'react-native';

export type Props = { packageName: string } & ViewProps;

const NativeView: React.ComponentType<Props> = requireNativeViewManager(
  'ExpoInstalledApplicationView',
);

export default function ExpoInstalledApplicationView(props: Props) {
  return <NativeView {...props} />;
}
