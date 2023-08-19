import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import ApplicationList from './src/pages/ApplicationList';
import Shopping from './src/pages/Shopping';
import ShoppingDetail from './src/pages/ShoppingDetail';

const Tab = createMaterialTopTabNavigator();
const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Tabs" component={Tabs} />
        <Stack.Screen name="ShoppingDetail" component={ShoppingDetail} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

function Tabs() {
  return (
    <Tab.Navigator
      initialRouteName="Feed"
      screenOptions={{
        tabBarActiveTintColor: '#e91e63',
        tabBarLabelStyle: { fontSize: 12 },
        tabBarStyle: { backgroundColor: 'powderblue' },
      }}>
      <Tab.Screen name="Shopping" component={Shopping}
        options={{ tabBarLabel: 'お買い物' }} />
      <Tab.Screen name="ApplicationList" component={ApplicationList}
        options={{ tabBarLabel: 'アプリ一覧' }} />
    </Tab.Navigator>
  )
}
