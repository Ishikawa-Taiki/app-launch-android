import { createSlice, createAsyncThunk, createSelector, PayloadAction } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';
import { ShoppingService, fetchShoppingServices } from '../../api/fetch-shopping-services';

// Define a type for the slice state
export interface State {
  services: ShoppingService[];
  status: 'idle' | 'loading' | 'succeeded' | 'failed';
  error: any;
}

// Define the initial state using that type
const initialState: State = {
  services: [],
  status: 'idle',
  error: null,
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
  initialState,
  reducers: {
    prepare: (state) => {
      state.services = dummyData;
    },
  },
  extraReducers(builder) {
    builder
      .addCase(fetch.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(fetch.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.services = action.payload;
      })
      .addCase(fetch.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

// Action creators are generated for each case reducer function
export const { prepare } = counterSlice.actions;

export const selectServices = (state: RootState) => state.shopping.services;
export const selectServicesByParentName = (state: RootState, parentName: string) =>
  state.shopping.services.filter((service) => service.parentName === parentName);

export const fetch = createAsyncThunk('shopping/fetch', async () => {
  return await fetchShoppingServices();
});

export default counterSlice.reducer;
