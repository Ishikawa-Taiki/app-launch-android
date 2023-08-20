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
    parentName: 'root',
    type: 'group',
  },
  {
    data: 'data2',
    parentName: 'root',
    type: 'group',
  },
  {
    data: 'data3',
    parentName: 'root',
    type: 'text',
  },
  {
    data: 'data4',
    parentName: 'data1',
    type: 'title-text',
  },
  {
    data: 'data5',
    parentName: 'data1',
    type: 'link',
  },
  {
    data: 'data6',
    parentName: 'parentName3',
    type: 'application',
  },
] as ShoppingService[];

export const counterSlice = createSlice({
  name: 'shopping',
  initialState: { services: dummyData },
  reducers: {
    prepare: (state) => {
      state.services = dummyData;
    },
  },
});

// Action creators are generated for each case reducer function
export const { prepare } = counterSlice.actions;

export const selectServices = (state: RootState) => state.shopping.services;

export default counterSlice.reducer;
