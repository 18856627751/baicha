package com.ben.jdemo.savor.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author： BaiCha
 * @Time:2019/1/15
 * @description :glide封装
 */
public class GlideUtil {

    public static void normal(Context context, int resouce, ImageView view){
        Glide.with(context).load(resouce).into(view);
    }
}
