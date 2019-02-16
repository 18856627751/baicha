package com.ben.jdemo.savor.mvp.model;

import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.ben.jdemo.savor.mvp.model.modleinterface.RegisterAccountListener;
import com.google.gson.Gson;

/**
 * @author: BaiCha
 * @Time: ---2019/2/16---
 * @description:
 */
public class RegisterModel {

    public void setAcountRegist(String account , String pass , RegisterAccountListener listener){
        if(listener==null){return;}
        if(account==null){listener.accountEmpty();return;}
        if(account.length()==0){listener.accountEmpty();return;}
        if(account.length()<=6){listener.accountLengthShort();return;}
        if(pass==null){listener.passEmpty();return;}
        if(pass.length()==0){listener.passEmpty();return;}
        if(pass.length()<=6){listener.passLengthShort();return;}
        LoginInfoBean.DataBean date=new LoginInfoBean.DataBean();
        date.setAcount(account);
        date.setPassword(pass);
        listener.nextStep(date);
    }

    public void FaceUnit(){

    }
}
