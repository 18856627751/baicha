package com.ben.jdemo.savor.util;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.XLog;


/**
 * @author： BaiCha
 * @Time:2019/1/18
 * @description :只显示在Debug的比较好使的log
 */
public class TLog {

    public static void init(){
        LogConfiguration configuration = new LogConfiguration.Builder().st(3).b().t().build();
        XLog.init(configuration);
    }

    public static void d(String tag,String msg){
        XLog.d(tag+" "+msg);
    }

    public static void d(String tag, String[] str){
        if(str==null){return;}
        if(str.length==0){return;}
        StringBuilder builder=new StringBuilder();
        builder.append("array:{");
        for (int i = 0; i < str.length; i++) {
            builder.append("[").append(i).append("]").append(str[i]);
        }
        builder.append("}");
        XLog.d(tag,builder.toString());
    }

    public static void i(String tag,String msg){
        XLog.i(tag+" "+msg);
    }

    public static void i(String tag, String[] str){
        if(str==null){return;}
        if(str.length==0){return;}
        StringBuilder builder=new StringBuilder();
        builder.append("array:{");
        for (int i = 0; i < str.length; i++) {
            builder.append("[").append(i).append("]").append(str[i]);
        }
        builder.append("}");
        XLog.d(tag,builder.toString());
    }

    public static void w(String tag,String msg){
        XLog.w(tag+" "+msg);
    }

    public static void w(String tag, String[] str){
        if(str==null){return;}
        if(str.length==0){return;}
        StringBuilder builder=new StringBuilder();
        builder.append("array:{");
        for (int i = 0; i < str.length; i++) {
            builder.append("[").append(i).append("]").append(str[i]);
        }
        builder.append("}");
        XLog.d(tag,builder.toString());
    }

    public static void e(String tag,String msg){
        XLog.e(tag+" "+msg);
    }

    public static void e(String tag, String[] str){
        if(str==null){return;}
        if(str.length==0){return;}
        StringBuilder builder=new StringBuilder();
        builder.append("array:{");
        for (int i = 0; i < str.length; i++) {
            builder.append("[").append(i).append("]").append(str[i]);
        }
        builder.append("}");
        XLog.d(tag,builder.toString());
    }
}
