package com.ben.jdemo.savor.base;

import android.app.Application;
import android.content.Context;

import com.ben.jdemo.savor.util.TLog;

/**
 * @author： BaiCha
 * @Time:2019/1/18
 * @description :
 */
public class BaiChaApplication extends Application{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        //初始化打印日志
        TLog.init();
    }

    public static Context getContext(){return mContext;}
}
