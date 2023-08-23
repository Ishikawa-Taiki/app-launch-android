// import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// // Import the native module. On web, it will be resolved to ExpoInstalledApplicationView.web.ts
// // and on native platforms to ExpoInstalledApplicationView.ts
// import ExpoInstalledApplicationView from './src/ExpoInstalledApplicationView';
// import {
//   ChangeEventPayload,
//   ExpoInstalledApplicationViewProps,
// } from './src/ExpoInstalledApplicationView.types';
// import ExpoInstalledApplicationViewModule from './src/ExpoInstalledApplicationViewModule';

// // Get the native constant value.
// export const PI = ExpoInstalledApplicationViewModule.PI;

// export function hello(): string {
//   return ExpoInstalledApplicationViewModule.hello();
// }

// export async function setValueAsync(value: string) {
//   return await ExpoInstalledApplicationViewModule.setValueAsync(value);
// }

// const emitter = new EventEmitter(
//   ExpoInstalledApplicationViewModule ?? NativeModulesProxy.ExpoInstalledApplicationView,
// );

// export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
//   return emitter.addListener<ChangeEventPayload>('onChange', listener);
// }

// export { ExpoInstalledApplicationView, ExpoInstalledApplicationViewProps, ChangeEventPayload };

import ExpoInstalledApplicationViewModule from './src/ExpoInstalledApplicationViewModule';

export function launchForPackageName(packageName: string) {
  return ExpoInstalledApplicationViewModule.launchForPackageName(packageName);
}

// export function setTheme(theme: string): void {
//   return ExpoSettingsModule.setTheme(theme);
// }

export { default as ImageView, Props as ImageViewProps } from './src/ExpoInstalledApplicationView';
