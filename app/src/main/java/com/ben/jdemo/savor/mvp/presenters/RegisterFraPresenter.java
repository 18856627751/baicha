package com.ben.jdemo.savor.mvp.presenters;

import com.ben.jdemo.savor.mvp.model.RegisterModel;
import com.ben.jdemo.savor.mvp.model.modleinterface.RegisterAccountListener;

/**
 * @author: BaiCha
 * @Time: ---2019/2/16---
 * @description:
 */
public class RegisterFraPresenter {

    private  RegisterModel modle;
    public RegisterFraPresenter(){
        this.modle=new RegisterModel();
    }

    public void setFraAccountModel(String account,String pass,RegisterAccountListener accountListener){
        if(accountListener!=null){
            modle.setAccountRegister(account,pass,accountListener);
        }

    }



}
