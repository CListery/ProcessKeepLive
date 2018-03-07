package com.cyh.keeplive.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.cyh.keeplive.KeepLiveManager;

/**
 * Created by yh on 18-3-7.
 */

public class KeepLiveReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = "KeepLiveReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(LOG_TAG, "act: " + action);
        if (TextUtils.equals(Intent.ACTION_SCREEN_OFF, action)) {
            KeepLiveManager.getInstance().startKeepLiveAct();
        } else if (TextUtils.equals(Intent.ACTION_USER_PRESENT, action)) {
            KeepLiveManager.getInstance().finishKeepLiveAct();
        }
    }
}
