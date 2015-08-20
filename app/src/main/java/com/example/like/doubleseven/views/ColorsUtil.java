package com.example.like.doubleseven.views;

/**
 * Created by like on 2015/8/20.
 */
public class ColorsUtil {
    public static int[] colors = new int[] {0xFF9B5A09,0xFFD4A3FA,0xFF7A1C5A,0xFF476E95,0xFFC7B43F,0xFFA4842F};

    public static int[] randomColor(int size) {
        int[] returncolors = new int[size];
        for (int i=0;i<size;i++) {
            returncolors[i] = colors[(int)(Math.random()*6)];
        }
        return returncolors;
    }
}
