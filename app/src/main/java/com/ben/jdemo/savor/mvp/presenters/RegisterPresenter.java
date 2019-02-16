package com.ben.jdemo.savor.mvp.presenters;

import com.ben.jdemo.savor.mvp.model.RegisterModel;
import com.ben.jdemo.savor.mvp.model.modleinterface.RegisterAccountListener;
import com.ben.jdemo.savor.mvp.view.RegisterNumFraIView;

/**
 * @author: BaiCha
 * @Time: ---2019/2/16---
 * @description:
 */
public class RegisterPresenter {

    private RegisterNumFraIView view;
    private  RegisterModel modle;
    private RegisterAccountListener accountListener;
    public RegisterPresenter(RegisterNumFraIView view,
                             RegisterAccountListener accountListener){
        this.view=view;
        this.modle=new RegisterModel();
        this.accountListener=accountListener;
    }

    public void setFraAccountModel(String account,String pass){
        if(accountListener!=null){
            modle.setAcountRegist(account,pass,accountListener);
        }

    }



}
