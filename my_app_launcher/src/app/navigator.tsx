import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import { ViewSpec } from '../common/const';
import ShoppingDetail from '../features/shopping/pages/ShoppingDetail';
import Shopping from '../features/shopping/pages/Shopping';
import ApplicationList from '../features/installed/pages/ApplicationList';

const Tab = createMaterialTopTabNavigator();
const Stack = createNativeStackNavigator();

export default function RootNavigator(): JSX.Element {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerTintColor: ViewSpec.FontStyle.appTopNavigatorTextColor,
          headerStyle: { backgroundColor: ViewSpec.Color.appTopNavigatorBackground },
          headerTitle: ViewSpec.TextDefinition.headerTitleDefault,
        }}
      >
        <Stack.Screen name='Tabs' component={Tabs} />
        <Stack.Screen name='ShoppingDetail' component={ShoppingDetail} />
      </Stack.Navigator>
    </NavigationContainer>
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
