import { Button, StyleSheet, Text, View } from 'react-native';

export default function ShoppingDetail({ navigation }) {
	return (
		<View style={styles.container}>
			<Text>ShoppingDetail</Text>
			<Button
				onPress={() => {
					navigation.push('ShoppingDetail')
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
