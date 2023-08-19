import { StyleSheet, Pressable, View, Text } from "react-native";
import { ViewSpec } from "../const";

export type ApplicationProps = {
	onPress?: () => void;
	title: string;
	packageName: string;
}

export const Application = (props: ApplicationProps) => (
	<Pressable style={styles.item} onPress={props.onPress}>
		<View style={styles.icon} />
		<Text style={styles.title}>{props.title}</Text>
	</Pressable>
)

const styles = StyleSheet.create({
	item: {
		backgroundColor: ViewSpec.Color.listBackground,
		flexDirection: "row",
		alignItems: "center",
		paddingHorizontal: ViewSpec.Margin.listItem,
		height: ViewSpec.ImageSize.listIcon + ViewSpec.Margin.listItem * 2,
		borderWidth: ViewSpec.BorderStyle.listBorderWidth,
		borderColor: ViewSpec.BorderStyle.listBorderColor,
	},
	icon: {
		backgroundColor: ViewSpec.Color.todo,
		width: ViewSpec.ImageSize.listIcon,
		height: ViewSpec.ImageSize.listIcon,
	},
	title: {
		marginLeft: ViewSpec.Margin.imageText,
		fontSize: ViewSpec.FontSize.listItem,
	},
});