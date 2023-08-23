import ExpoInstalledApplicationViewModule from './src/ExpoInstalledApplicationViewModule';

export function launchForPackageName(packageName: string) {
  return ExpoInstalledApplicationViewModule.launchForPackageName(packageName);
}

export function installedPackages() {
  return ExpoInstalledApplicationViewModule.installedPackages();
}

export {
  default as InstalledApplicationView,
  ExpoInstalledApplicationViewProps as ImageViewProps,
} from './src/ExpoInstalledApplicationView';
