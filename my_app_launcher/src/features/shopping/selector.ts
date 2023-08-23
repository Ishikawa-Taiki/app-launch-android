import { createSelector } from '@reduxjs/toolkit';

import { RootState } from '../../app/store';

export const selectServices = (state: RootState) => state.shopping.data.services;
export const selectServicesByParentName = (state: RootState, parentName: string) =>
  state.shopping.data.services.filter((service) => service.parentName === parentName);
export const selectServiceParentName = (state: RootState, parentName: string) => parentName;
export const selectServicesByParentName2 = createSelector(
  [selectServices, selectServiceParentName],
  (services, parentName) => services.filter((service) => service.parentName === parentName),
);
export const selectApplications = (state: RootState) => state.shopping.data.applications;
export const selectApplicationsByShortName = (state: RootState, shortName: string) =>
  state.shopping.data.applications.find((application) => application.shortName === shortName);
export const selectLoadingStatus = (state: RootState) => state.shopping.status;
export const selectErrorStatus = (state: RootState) => state.shopping.error;
