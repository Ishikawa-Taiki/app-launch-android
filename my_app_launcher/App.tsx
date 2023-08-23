import React from 'react';
import { Provider } from 'react-redux';

import RootNavigator from './src/app/navigator';
import { store } from './src/app/store';

export default function App() {
  return (
    <Provider store={store}>
      <RootNavigator />
    </Provider>
  );
}
