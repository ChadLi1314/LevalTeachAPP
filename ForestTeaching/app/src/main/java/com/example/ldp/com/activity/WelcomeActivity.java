package com.example.ldp.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.ldp.com.forestteaching.MainActivity;
import com.example.ldp.com.forestteaching.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_welcome);

        //加载缓冲页面
        final Intent intent=new Intent();
        Timer time=new Timer();
        TimerTask task =new TimerTask(){
            @Override
            public void run() {
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                WelcomeActivity.this.startActivity(intent);
                finish();
            }
        };
        time.schedule(task, 1000*7);
    }

}
