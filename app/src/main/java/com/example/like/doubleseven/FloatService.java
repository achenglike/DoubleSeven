package com.example.like.doubleseven;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

/**
 * Created by like on 2015/8/20.
 */
public class FloatService extends Service {

    public static int UPDATE_SIGNAL = 0x0001;
    UIHandler handler;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new UIHandler();
        FloatUtil.addView(getApplicationContext());
        handler.sendEmptyMessage(UPDATE_SIGNAL);
    }

    @Override
    public void onDestroy() {
        handler.removeMessages(UPDATE_SIGNAL);
        FloatUtil.removeView();
        super.onDestroy();
    }

    static class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == UPDATE_SIGNAL) {
                FloatUtil.updateView();
                sendEmptyMessageDelayed(UPDATE_SIGNAL, 100);
            }
        }
    }
}
