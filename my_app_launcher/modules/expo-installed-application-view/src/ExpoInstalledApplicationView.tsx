import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';
import { ViewProps } from 'react-native';

export type ExpoInstalledApplicationViewProps = { packageName: string } & ViewProps;

const NativeView: React.ComponentType<ExpoInstalledApplicationViewProps> = requireNativeViewManager(
  'ExpoInstalledApplicationView',
);

export default function ExpoInstalledApplicationView(props: ExpoInstalledApplicationViewProps) {
  return <NativeView {...props} />;
}
