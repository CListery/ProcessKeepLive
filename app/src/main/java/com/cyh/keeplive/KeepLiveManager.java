package com.cyh.keeplive;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.cyh.keeplive.activitys.KeepLiveActivity;

/**
 * Created by yh on 18-3-7.
 */

public class KeepLiveManager {

    private static KeepLiveManager mInstance;

    private Handler mActHandler;

    private KeepLiveManager() {
    }

    public static KeepLiveManager getInstance() {
        if (null == mInstance) {
            mInstance = new KeepLiveManager();
        }
        return mInstance;
    }

    public void startKeepLiveAct() {
        Context ctx = ProcessApplication.get();
        Intent intent = new Intent(ctx, KeepLiveActivity.class);
        ctx.startActivity(intent);
    }

    public void finishKeepLiveAct() {
        if (null != mActHandler) {
            mActHandler.sendEmptyMessage(0);
        }
    }

    public void saveHandler(Handler handler) {
        mActHandler = handler;
    }
}
