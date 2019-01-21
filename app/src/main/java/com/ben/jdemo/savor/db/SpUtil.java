package com.ben.jdemo.savor.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ben.jdemo.savor.base.BaiChaApplication;
import com.ben.jdemo.savor.constant.Parameter;

/**
 * @author： BaiCha
 * @Time:2019/1/20
 * @description :
 */
public class SpUtil {

    private static SharedPreferences spLogin;
    private static SharedPreferences.Editor editor;

    private static SpUtil sp;
    public static SpUtil getInstance(){
        if(sp==null){
            synchronized (SpUtil.class){
                if(sp==null){
                    sp=new SpUtil();
                }
            }
        }
        if(spLogin==null||editor==null){
            spLogin = BaiChaApplication.getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
            editor = spLogin.edit();
        }
        return sp;
    }

    public void setStringInfo(String key,String info){
        editor.putString(key,info);
        editor.apply();
    }

    public String getStringInfo(String key){
        return  spLogin.getString(key, Parameter.ERROR);

    }


    public static void clearSpUtil(){
        if(editor!=null){
            editor.clear();
            editor=null;
        }
        if(spLogin!=null){
            spLogin=null;
        }

    }




}
