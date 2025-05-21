# react-native-simple-intent-linking

[![npm version](https://img.shields.io/npm/v/react-native-simple-intent-linking.svg)](https://www.npmjs.com/package/react-native-simple-intent-linking)
[![license: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![platforms](https://img.shields.io/badge/platforms-android%20%7C%20ios-green.svg)](#)

A lightweight React Native module to easily handle Android `intent://` links — typically used to launch other apps like PASS, Kakao, or other deep links.

✅ Supports:
- Android `intent://` links (custom app launch)
- Fallback to React Native's `Linking` on iOS
- Automatic platform handling with clean API

---

## 📦 Installation

```bash
yarn add react-native-simple-intent-linking
```

> This module is written in Kotlin and supports autolinking (React Native 0.60+).

---

## 🚀 Usage

### Import the module

```js
import SimpleLinking from 'react-native-simple-intent-linking';
```

---

### 📲 Open an Android Intent URL

```js
await SimpleLinking.openURL(
    'intent://...your_intent_link'
);
```

- If the target app is installed, it will be launched.
- On iOS or non-`intent://` links, it will fall back to `Linking.openURL`.

---

### ✅ Check if the intent link is valid

```js
const canOpen = await SimpleLinking.canOpenURL(
  'intent://...your_intent_link'
);

if (canOpen) {
  // You can safely open the link
}
```

---

## 🧩 Platform behavior

| Platform | Behavior |
|----------|----------|
| **Android** | Uses native Kotlin module to handle `intent://` schemes via `startActivity()` |
| **iOS** | Falls back to `Linking.openURL()` since intent-style URLs are not used |

---

## 📄 License

MIT  
Developed by [Arthur-Noh](https://github.com/Arthur-Noh)
