import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import sample1 from './src/pages/sample1';
import sample2 from './src/pages/sample2';
import React from 'react';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
    <Stack.Navigator>
      <Stack.Screen name="sample1" component={sample1} />
      <Stack.Screen name="sample2" component={sample2} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
