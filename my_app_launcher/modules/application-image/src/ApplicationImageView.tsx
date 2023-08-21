import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { ApplicationImageViewProps } from './ApplicationImage.types';

const NativeView: React.ComponentType<ApplicationImageViewProps> =
  requireNativeViewManager('ApplicationImage');

export default function ApplicationImageView(props: ApplicationImageViewProps) {
  return <NativeView {...props} />;
}
