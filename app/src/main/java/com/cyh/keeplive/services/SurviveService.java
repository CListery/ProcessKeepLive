package com.cyh.keeplive.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yh on 18-3-1.
 */

public class SurviveService extends Service {

    private static final String LOG_TAG = "SurviveService";

    private HandlerThread mSurviveThread;
    private Handler mSurviveHandle;

    public class SurviveBinder extends Binder {
        public SurviveService getService() {
            return SurviveService.this;
        }
    }

    private IBinder mBinder = new SurviveBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
        mSurviveThread = new HandlerThread(LOG_TAG + "::L");
        mSurviveThread.start();
        mSurviveHandle = new Handler(mSurviveThread.getLooper());
        mSurviveHandle.post(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(LOG_TAG, "run: " + ++count);
                }
            }
        });
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LOG_TAG, "onUnbind");
        return super.onUnbind(intent);
    }

}
