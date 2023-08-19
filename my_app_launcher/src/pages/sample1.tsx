import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function sample1({ navigation }) {
	return (
		<View style={styles.container}>
			<Text>sample1</Text>
			<StatusBar style="auto" />
			<Button
				onPress={() => {
					navigation.push('sample1')
				}}
				title="TEST"
				color="#841584"
			/>
		</View>
	);
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		backgroundColor: '#fff',
		alignItems: 'center',
		justifyContent: 'center',
	},
});
