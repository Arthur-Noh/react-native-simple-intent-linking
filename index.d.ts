declare module 'react-native-simple-intent-linking' {

    export interface SimpleIntentLinkingProps {
        openURL: (url: string) => Promise<any>;
        canOpenURL: (url: string) => Promise<boolean>;
    }

    const SimpleLinking: SimpleIntentLinkingProps

    export default SimpleLinking;
}
