import { configureStore } from '@reduxjs/toolkit';
import shopping from '../features/shopping/slice';

export default configureStore({
  reducer: {
    shopping: shopping,
  },
});
