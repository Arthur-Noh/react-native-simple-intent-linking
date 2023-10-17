import { NativeModules, Linking, Platform } from 'react-native';

const { RNSimpleIntentLinking } = NativeModules;

const openURL = (url) => {
    if (Platform.OS !== 'android' || url.indexOf('intent:') !== 0) {
        return Linking.openURL(url);
    }

    if (RNSimpleIntentLinking) {
        return RNSimpleIntentLinking.openURL(url);
    }

    return new Promise((resolve, reject) => reject('not found modules'));
};

const canOpenURL = (url) => {
    if (Platform.OS !== 'android' || url.indexOf('intent:') !== 0) {
        return Linking.openURL(url);
    }

    if (RNSimpleIntentLinking) {
        return RNSimpleIntentLinking.canOpenURL(url);
    }

    return new Promise((resolve, reject) => reject('not found modules'));
};

export default {
    openURL,
    canOpenURL,
};
