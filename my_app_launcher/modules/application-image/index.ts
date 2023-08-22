import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to ApplicationImage.web.ts
// and on native platforms to ApplicationImage.ts
import { ChangeEventPayload, ApplicationImageViewProps } from './src/ApplicationImage.types';
import ApplicationImageModule from './src/ApplicationImageModule';
import ApplicationImageView from './src/ApplicationImageView';

// Get the native constant value.
export const PI = ApplicationImageModule.PI;

export async function hello() {
  return await ApplicationImageModule.hello();
}

export async function setValueAsync(value: string) {
  return await ApplicationImageModule.setValueAsync(value);
}
export async function launchForPackageName(packageName: string): Promise<void> {
  return await ApplicationImageModule.launchForPackageName(packageName);
}
export async function installedPackages(): Promise<string> {
  return await ApplicationImageModule.installedPackages();
}

const emitter = new EventEmitter(ApplicationImageModule ?? NativeModulesProxy.ApplicationImage);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { ApplicationImageView, ApplicationImageViewProps, ChangeEventPayload };
