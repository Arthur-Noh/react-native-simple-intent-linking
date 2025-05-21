declare module 'react-native-simple-intent-linking' {
    /**
     * Opens the given URL. If on Android and using `intent://`, it will delegate to the native module.
     * Otherwise falls back to `Linking.openURL`.
     */
    export function openURL(url: string): Promise<any>;

    /**
     * Checks whether the given URL can be opened.
     */
    export function canOpenURL(url: string): Promise<boolean>;

    const SimpleLinking: {
        openURL: typeof openURL;
        canOpenURL: typeof canOpenURL;
    };

    export default SimpleLinking;
}
