import { createSelector } from '@reduxjs/toolkit';

import { RootState } from '../../app/store';

export const selectServices = (state: RootState) => state.shopping.data.services;
export const selectServicesByParentName = createSelector(
  [selectServices, (_state: RootState, parentName: string) => parentName],
  (services, parentName) => services.filter((service) => service.parentName === parentName),
);

export const selectApplications = (state: RootState) => state.shopping.data.applications;
export const selectApplicationsByShortName = createSelector(
  [selectApplications, (_state: RootState, shortName: string) => shortName],
  (applications, shortName) =>
    applications.find((application) => application.shortName === shortName),
);

export const selectLoadingStatus = (state: RootState) => state.shopping.status;
export const selectErrorStatus = (state: RootState) => state.shopping.error;
