import { RootState } from '../../app/store';

export const selectServices = (state: RootState) => state.shopping.data.services;
export const selectServicesByParentName = (state: RootState, parentName: string) =>
  state.shopping.data.services.filter((service) => service.parentName === parentName);
export const selectApplications = (state: RootState) => state.shopping.data.applications;
export const selectApplicationsByShortName = (state: RootState, shortName: string) =>
  state.shopping.data.applications.find((application) => application.shortName === shortName);
