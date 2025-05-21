import { NativeModules, Linking, Platform } from 'react-native';

const { RNSimpleIntentLinking } = NativeModules;

/**
 * Open a URL using native linking or custom Android intent.
 */
const openURL = (url) => {
    if (Platform.OS !== 'android' || !url.startsWith('intent:')) {
        return Linking.openURL(url);
    }

    // Android intent://
    if (RNSimpleIntentLinking && RNSimpleIntentLinking.openURL) {
        return RNSimpleIntentLinking.openURL(url);
    }

    return Promise.reject(new Error('RNSimpleIntentLinking module not found'));
};

/**
 * Check if a URL can be opened.
 */
const canOpenURL = (url) => {
    if (Platform.OS !== 'android' || !url.startsWith('intent:')) {
        return Linking.canOpenURL(url);
    }

    if (RNSimpleIntentLinking && RNSimpleIntentLinking.canOpenURL) {
        return RNSimpleIntentLinking.canOpenURL(url);
    }

    return Promise.reject(new Error('RNSimpleIntentLinking module not found'));
};

export default {
    openURL,
    canOpenURL,
};
