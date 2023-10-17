# react-native-simple-intent-linking

## Getting started

`$ yarn add react-native-simple-intent-linking`

## Usage
```javascript
import SimpleLinking from 'react-native-simple-intent-linking';

// open other app
await SimpleLinking.openURL('intent://...INTENT-LINK...');

// check is vaild intent link
await SimpleLinking.canOpenURL('intent://...INTENT-LINK...'); // boolean
```
  