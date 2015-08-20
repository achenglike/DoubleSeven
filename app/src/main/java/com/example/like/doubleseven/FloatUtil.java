package com.example.like.doubleseven;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.like.doubleseven.views.FloatHeart;


/**
 * Created by like on 2015/8/20.
 */
public class FloatUtil {

    private static FloatHeart floatView;
    private static WindowManager mWindowManager;
    private static Context applicationContext;
    private static boolean isAdded = false;

    public static void addView(final Context context){
        if (isAdded)
            return;
        applicationContext = context.getApplicationContext();
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        floatView = new FloatHeart(context);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                |WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                |WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        layoutParams.format = PixelFormat.TRANSLUCENT;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.CENTER;

        mWindowManager.addView(floatView, layoutParams);
        isAdded = true;
    }

    public static void updateView(){
        floatView.update();


    }

    public static void removeView(){
        if (isAdded && floatView != null) {
            mWindowManager.removeView(floatView);
            isAdded = false;
        }
    }
}
