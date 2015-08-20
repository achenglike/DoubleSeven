package com.example.like.doubleseven.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by like on 2015/8/20.
 */
public class HeartBean {
    private static final int liefetimeshreshold = 8;
    private int locationX;
    private int locationY;
    private float rate;
    private int[] colors;
    private int lifetime;

    // 画心path
    private Path path;

    private int width,height;

    public HeartBean(int width, int height) {
        this.width = width;
        this.height = height;
        path = new Path();
    }

    public void randomParam(){
        colors = ColorsUtil.randomColor(liefetimeshreshold);
        rate = 1;
        lifetime = liefetimeshreshold;
        locationX = (int) ((Math.random()*width)+1);
        locationY = (int) ((Math.random()*height)+1);
    }

    public void draw(Canvas canvas, Paint paint) {
        if (lifetime <= 0){
            randomParam();
        } else {
            paint.setColor(colors[liefetimeshreshold - lifetime]);
            paint.setShadowLayer(3,3,3,colors[liefetimeshreshold - lifetime]);
            drawHeartPath(rate);
            canvas.drawPath(path,paint);
            lifetime--;
            rate += 0.1f;
        }

    }

    private void drawHeartPath(float rate) {
        float cumpLocationX = locationX-178/2*(rate-1);
        float cumpLocationY = locationY-210/2*(rate-1);
        path.reset();
        path.moveTo(cumpLocationX + 75 * rate, cumpLocationY + 40 * rate);
        path.cubicTo(cumpLocationX + 75 * rate, cumpLocationY + 37 * rate, cumpLocationX + 70 * rate, cumpLocationY + 25 * rate, cumpLocationX + 50 * rate, cumpLocationY + 25 * rate);
        path.cubicTo(cumpLocationX + 20 * rate, cumpLocationY + 25 * rate, cumpLocationX + 20 * rate, cumpLocationY + 62.5f * rate, cumpLocationX + 20 * rate, cumpLocationY + 62.5f * rate);
        path.cubicTo(cumpLocationX+20*rate, cumpLocationY +80*rate, cumpLocationX+40*rate, cumpLocationY +102*rate, cumpLocationX+75*rate, cumpLocationY +120*rate);
        path.cubicTo(cumpLocationX+110*rate,cumpLocationY +102*rate,cumpLocationX+130*rate,cumpLocationY +80*rate,cumpLocationX+130*rate,cumpLocationY +62.5f*rate);
        path.cubicTo(cumpLocationX+130*rate,cumpLocationY +62.5f*rate,cumpLocationX+130*rate,cumpLocationY +25*rate,cumpLocationX+100*rate,cumpLocationY +25*rate);
        path.cubicTo(cumpLocationX+85*rate,cumpLocationY +25*rate,cumpLocationX+75*rate,cumpLocationY +37*rate,cumpLocationX+75*rate,cumpLocationY +40*rate);
        path.close();
    }
}
