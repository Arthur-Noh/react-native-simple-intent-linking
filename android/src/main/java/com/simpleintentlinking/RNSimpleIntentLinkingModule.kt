package com.simpleintentlinking

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class RNSimpleIntentLinkingModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private val reactContext: ReactApplicationContext = reactContext

    override fun getName(): String {
        return "RNSimpleIntentLinking"
    }

    @ReactMethod
    fun openURL(url: String, promise: Promise) {
        try {
            val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            reactContext.currentActivity?.startActivity(intent)
            promise.resolve(null)
        } catch (exception: Exception) {
            promise.reject(exception)
        }
    }

    @ReactMethod
    fun canOpenURL(url: String, promise: Promise) {
        try {
            val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
            val manager: PackageManager = reactContext.packageManager
            val infoList: List<ResolveInfo> = manager.queryIntentActivities(intent, 0)

            promise.resolve(infoList.isNotEmpty())
        } catch (exception: Exception) {
            promise.reject(exception)
        }
    }
}
