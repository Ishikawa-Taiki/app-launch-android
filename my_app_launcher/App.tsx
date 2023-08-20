import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import ApplicationList from './src/features/installed/pages/ApplicationList';
import Shopping from './src/features/shopping/pages/Shopping';
import ShoppingDetail from './src/features/shopping/pages/ShoppingDetail';
import { ViewSpec } from './src/common/const';
import { Provider } from 'react-redux';
import { store } from './src/app/store';

const Tab = createMaterialTopTabNavigator();
const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator
          screenOptions={{
            headerTintColor: ViewSpec.FontStyle.appTopNavigatorTextColor,
            headerStyle: { backgroundColor: ViewSpec.Color.appTopNavigatorBackground },
          }}
        >
          <Stack.Screen name='Tabs' component={Tabs} />
          <Stack.Screen name='ShoppingDetail' component={ShoppingDetail} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}

function Tabs() {
  return (
    <Tab.Navigator
      initialRouteName='Feed'
      screenOptions={{
        tabBarActiveTintColor: ViewSpec.FontStyle.tabNavigatorTextColor,
        tabBarLabelStyle: { fontSize: ViewSpec.FontSize.tabNavigatorText },
        tabBarStyle: { backgroundColor: ViewSpec.Color.tabNavigatorBackground },
      }}
    >
      <Tab.Screen
        name='Shopping'
        component={Shopping}
        options={{ tabBarLabel: ViewSpec.TextDefinition.shoppingTab }}
      />
      <Tab.Screen
        name='ApplicationList'
        component={ApplicationList}
        options={{ tabBarLabel: ViewSpec.TextDefinition.applicationListTab }}
      />
    </Tab.Navigator>
  );
}
