package com.ben.jdemo.savor.util.enumstyle;


import androidx.annotation.ColorInt;

/**
 * @author： BaiCha
 * @Time:2019/1/14
 * @description :状态栏的样式
 */
public enum StatusBar {
    HIDE,
    TRANSPARENT,
    COLOR(1,1);


    private int color;
    private int alpha;

    StatusBar(){}
    StatusBar(@ColorInt int color, int alpha){
        this.color=color;
        this.alpha=alpha;
    }
}
