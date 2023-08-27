import { configureStore } from '@reduxjs/toolkit';

import shopping from '../features/shopping/slice';

export const store = configureStore({
  reducer: {
    shopping,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
