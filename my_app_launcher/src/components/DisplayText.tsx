import { StyleSheet, Pressable, View, Text } from "react-native";
import { ViewSpec } from "../const";

export type DisplayTextProps = {
	onPress?: () => void;
	text: string;
}

export const DisplayText = (props: DisplayTextProps) => (
	<Pressable style={styles.item} onPress={props.onPress}>
		<Text style={styles.title}>{props.text}</Text>
	</Pressable>
)

const styles = StyleSheet.create({
	item: {
		backgroundColor: ViewSpec.Color.disableListBackground,
		flexDirection: "row",
		alignItems: "center",
		paddingHorizontal: ViewSpec.Margin.listItem,
		height: ViewSpec.ImageSize.listIcon + ViewSpec.Margin.listItem * 2,
		borderWidth: ViewSpec.BorderStyle.listBorderWidth,
		borderColor: ViewSpec.BorderStyle.listBorderColor,
	},
	title: {
		fontSize: ViewSpec.FontSize.listItem,
		color: ViewSpec.FontStyle.displayTextColor,
		fontStyle: 'italic',
	},
});
