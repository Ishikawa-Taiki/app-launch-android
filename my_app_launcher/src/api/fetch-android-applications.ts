import { requestWebAPI } from './WebAPI';

export type AndroidApplication = {
  shortName: string;
  longName: string;
  packageName: string;
};

export async function fetchAndroidApplications() {
  return requestWebAPI<AndroidApplication[]>('exec?file=AndroidApplications&sheet=shopping');
}
