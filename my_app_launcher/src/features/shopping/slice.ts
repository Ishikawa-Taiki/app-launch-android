import { createSlice, createSelector, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';
import { ShoppingService } from '../../api/fetch-shopping-services';

// Define a type for the slice state
export interface State {
  services: ShoppingService[];
}

// Define the initial state using that type
const initialState: State = {
  services: [],
};

const dummyData = [
  {
    data: 'data1',
    parentName: 'parentName1',
    type: 'group',
  },
  {
    data: 'data2',
    parentName: 'parentName2',
    type: 'group',
  },
  {
    data: 'data3',
    parentName: 'parentName3',
    type: 'group',
  },
] as ShoppingService[];

export const counterSlice = createSlice({
  name: 'shopping',
  initialState,
  reducers: {
    prepare: (state) => {
      state.services = dummyData;
    },
  },
});

// Action creators are generated for each case reducer function
export const { prepare } = counterSlice.actions;

const selectServices = (state: RootState) => state.shopping;
const selectParentName = (state: RootState, parentName: string) => parentName;
export const makeSelectServicesByParentName = () => {
  const selectServicesByParentName = createSelector(
    [selectServices, selectParentName],
    (shopping: State, parentName: string) =>
      shopping.services.filter((service) => service.parentName === parentName),
  );
  return selectServicesByParentName;
};

export default counterSlice.reducer;
