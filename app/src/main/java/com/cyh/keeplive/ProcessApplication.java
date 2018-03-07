package com.cyh.keeplive;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.cyh.keeplive.receivers.KeepLiveReceiver;
import com.cyh.keeplive.services.SurviveService;

/**
 * Created by yh on 18-3-7.
 */

public class ProcessApplication extends Application {

    private static final String LOG_TAG = "ProcessApplication";

    private static ProcessApplication mInstance;

    private ServiceConnection mSC = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(LOG_TAG, "connected");
            if (null != service && service instanceof SurviveService.SurviveBinder) {
                SurviveService.SurviveBinder ss = (SurviveService.SurviveBinder) service;
                SurviveService targetService = ss.getService();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(LOG_TAG, "disconnected");
        }
    };

    public static ProcessApplication get() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        regLiveReceiver();
        bindServer();
    }

    private void bindServer() {
        bindService(new Intent(this, SurviveService.class), mSC, BIND_AUTO_CREATE);
    }

    private void regLiveReceiver() {
        KeepLiveReceiver receiver = new KeepLiveReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        filter.setPriority(Integer.MAX_VALUE);
        registerReceiver(receiver, filter);
    }

}
