import AsyncStorage from '@react-native-async-storage/async-storage';

export const save = async (k: string, v: string): Promise<void> => AsyncStorage.setItem(k, v);
export const load = async (k: string): Promise<string | null> => AsyncStorage.getItem(k);
