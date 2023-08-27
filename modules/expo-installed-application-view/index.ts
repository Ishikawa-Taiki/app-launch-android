import ExpoInstalledApplicationViewModule from './src/ExpoInstalledApplicationViewModule';

export function launchForPackageName(packageName: string) {
  return ExpoInstalledApplicationViewModule.launchForPackageName(packageName);
}

export type Package = { loadLabel: string; packageName: string };
export async function installedPackages(): Promise<Package[]> {
  return ExpoInstalledApplicationViewModule.installedPackages();
}

export {
  default as InstalledApplicationView,
  ExpoInstalledApplicationViewProps as ImageViewProps,
} from './src/ExpoInstalledApplicationView';
