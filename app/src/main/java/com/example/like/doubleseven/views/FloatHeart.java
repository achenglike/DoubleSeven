package com.example.like.doubleseven.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by like on 2015/8/20.
 */
public class FloatHeart extends View{

    private List<HeartBean> heartBeans;
    private int width;
    private int height;

    Paint paint;

    public FloatHeart(Context context) {
        super(context);
        heartBeans = new ArrayList<HeartBean>();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6.0f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    public void update(){

        if (heartBeans.size()<=20 && width!=0){
            heartBeans.add(new HeartBean(width,height));
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (HeartBean heartBean:heartBeans) {
            heartBean.draw(canvas, paint);
        }
    }

}
