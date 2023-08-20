import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';
import { ShoppingService, fetchShoppingServices } from './fetch-shopping-services';
import { load, save } from '../../common/storage';

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

export const counterSlice = createSlice({
  name: 'shopping',
  initialState,
  reducers: {},
  extraReducers(builder) {
    builder
      .addCase(prepare.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(prepare.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.services = action.payload;
      })
      .addCase(prepare.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      })
      .addCase(update.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(update.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.services = action.payload;
      })
      .addCase(update.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

// Action creators are generated for each case reducer function
export const {} = counterSlice.actions;

export const selectServices = (state: RootState) => state.shopping.services;
export const selectServicesByParentName = (state: RootState, parentName: string) =>
  state.shopping.services.filter((service) => service.parentName === parentName);

const STORAGE_KEY = 'shopping-services';

export const prepare = createAsyncThunk('shopping/prepare', async () => {
  const stringData = await load(STORAGE_KEY);
  return !!stringData ? (JSON.parse(stringData) as ShoppingService[]) : [];
});
export const update = createAsyncThunk('shopping/update', async () => {
  const data = await fetchShoppingServices();
  const stringData = JSON.stringify(data);
  await save(STORAGE_KEY, stringData);
  return data;
});

export default counterSlice.reducer;
