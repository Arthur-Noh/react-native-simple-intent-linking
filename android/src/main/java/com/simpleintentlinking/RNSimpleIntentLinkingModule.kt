package com.simpleintentlinking

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class RNSimpleIntentLinkingModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RNSimpleIntentLinking"
    }

    @ReactMethod
    fun openURL(url: String, promise: Promise) {
        try {
            val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            val activity = currentActivity
            if (activity != null) {
                activity.startActivity(intent)
            } else {
                reactContext.startActivity(intent)
            }

            promise.resolve(null)
        } catch (exception: Exception) {
            promise.reject("OPEN_URL_ERROR", "Failed to open URL: $url", exception)
        }
    }

    @ReactMethod
    fun canOpenURL(url: String, promise: Promise) {
        try {
            val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
            val manager: PackageManager = reactContext.packageManager
            val infoList = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)

            promise.resolve(infoList.isNotEmpty())
        } catch (exception: Exception) {
            promise.reject("CAN_OPEN_URL_ERROR", "Failed to check URL availability: $url", exception)
        }
    }
}
