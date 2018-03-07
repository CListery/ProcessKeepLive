package com.cyh.keeplive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cyh.keeplive.services.SurviveService;

/**
 * Created by yh on 18-3-1.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_go).setOnClickListener(this);

        startService(new Intent(this, SurviveService.class));
    }

    @Override
    public void onClick(View v) {
        //        Intent intent = new Intent(this, KeepLiveActivity.class);
        //        Rect r = new Rect(0, 0, 1, 1);
        //        intent.setSourceBounds(r);
        //        startActivity(intent);
        //        finish();
    }
}
