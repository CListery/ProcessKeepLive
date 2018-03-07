package com.cyh.keeplive.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.cyh.keeplive.KeepLiveManager;

/**
 * Created by yh on 18-3-1.
 */
public class KeepLiveActivity extends Activity {

    private final static String LOG_TAG = "KeepLiveActivity";

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.d(LOG_TAG, "ff");
            finish();
            return true;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        Rect r = getIntent().getSourceBounds();

        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);

        KeepLiveManager.getInstance().saveHandler(mHandler);
    }

    @Override
    public void finish() {
        Log.d(LOG_TAG, "f");
        super.finish();
    }
}
