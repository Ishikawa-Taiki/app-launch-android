
export type ShoppingService = {
	data: string,
	parentName: string,
	type: string
}

export async function fetchShoppingServices() {
	return requestWebAPI<ShoppingService[]>("exec?file=Services&sheet=shopping");
}
