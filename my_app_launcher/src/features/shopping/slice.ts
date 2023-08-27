import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';

import { AndroidApplication, fetchAndroidApplications } from './api/fetch-android-applications';
import { ShoppingService, fetchShoppingServices } from './api/fetch-shopping-services';
import { load, save } from '../../common/storage';

export type LoadingStatus = 'idle' | 'loading' | 'succeeded' | 'failed';

// Define a type for the slice state
export interface State {
  data: {
    services: ShoppingService[];
    applications: AndroidApplication[];
  };
  status: LoadingStatus;
  error: any;
}

// Define the initial state using that type
const initialState: State = {
  data: {
    services: [],
    applications: [],
  },
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
        state.data = action.payload;
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
        state.data = action.payload;
      })
      .addCase(update.rejected, (state, action) => {
        state.status = 'failed';
        state.error = action.error.message;
      });
  },
});

// Action creators are generated for each case reducer function
// export const {} = counterSlice.actions;

const SHOPPING_STORAGE_KEY = 'shopping-services';
const APPLICATION_STORAGE_KEY = 'android-applications';

export const prepare = createAsyncThunk('shopping/prepare', async () => {
  const servicesString = await load(SHOPPING_STORAGE_KEY);
  const applicationsString = await load(APPLICATION_STORAGE_KEY);
  const services = servicesString ? (JSON.parse(servicesString) as ShoppingService[]) : [];
  const applications = applicationsString
    ? (JSON.parse(applicationsString) as AndroidApplication[])
    : [];
  return { services, applications };
});

export const update = createAsyncThunk('shopping/update', async () => {
  const services = await fetchShoppingServices();
  const applications = await fetchAndroidApplications();
  await save(SHOPPING_STORAGE_KEY, JSON.stringify(services));
  await save(APPLICATION_STORAGE_KEY, JSON.stringify(applications));
  return { services, applications };
});

export default counterSlice.reducer;
