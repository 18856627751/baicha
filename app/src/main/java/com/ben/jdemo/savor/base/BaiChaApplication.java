package com.ben.jdemo.savor.base;

import android.app.Application;
import com.ben.jdemo.savor.util.TLog;

/**
 * @author： BaiCha
 * @Time:2019/1/18
 * @description :
 */
public class BaiChaApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化打印日志
        TLog.init();
    }
}
