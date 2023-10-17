package com.simpleintentlinking;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.List;

public class RNSimpleIntentLinkingModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNSimpleIntentLinkingModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSimpleIntentLinking";
  }

  @ReactMethod
  public void openURL(String url, Promise promise) {
    try {
      Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      reactContext.getCurrentActivity().startActivity(intent);
      promise.resolve(null);
    }
    catch(Exception exception) {
      promise.reject(exception);
    }
  }

  @ReactMethod
  public void canOpenURL(String url, Promise promise) {
    try {
      Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
      PackageManager manager = reactContext.getPackageManager();
      List<ResolveInfo> infoList = manager.queryIntentActivities(intent, 0);

      promise.resolve((infoList.size() > 0) ? Boolean.TRUE : Boolean.FALSE);
    }
    catch(Exception exception) {
      promise.reject(exception);
    }
  }
}
