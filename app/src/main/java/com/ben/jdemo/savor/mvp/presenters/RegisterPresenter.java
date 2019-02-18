package com.ben.jdemo.savor.mvp.presenters;

import android.view.View;
import android.widget.Toast;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.activity.RegisterActivity;
import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.ben.jdemo.savor.fragments.RegisterFaceFra;
import com.ben.jdemo.savor.fragments.RegisterNumFra;
import com.ben.jdemo.savor.util.enumstyle.RegisterFraEnum;
import com.ben.jdemo.savor.widget.RegisterProgress;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: BaiCha
 * @Time: ---2019/2/17---
 * @description:
 */
public class RegisterPresenter {


    private RegisterNumFra accountFra;
    private RegisterFaceFra faceFra;
    private RegisterFraEnum fraEnum;
    private RegisterActivity activity;
    private LoginInfoBean login;

    public RegisterPresenter( RegisterActivity activity){
        this.activity=activity;
    }

    public void initFragment(){
        accountFra = new RegisterNumFra();
        faceFra=new RegisterFaceFra();
        activity.addFragment(R.id.fra_register_content, accountFra, "accountFra");
        fraEnum = RegisterFraEnum.ACCOUNT;
        Toast.makeText(activity, "客官还没有账号，注册一个吧（>.<）", Toast.LENGTH_SHORT).show();
    }

    public void setOnClick(View view,RegisterProgress rpProgressTea) {
        switch (view.getId()){
            case R.id.bt_next_step:
                nextStep(rpProgressTea);
                break;
        }
    }

    public void nextStep(RegisterProgress rpProgressTea){
        if (fraEnum == RegisterFraEnum.ACCOUNT) {
            accountFra.setOnClick();
            rpProgressTea.setProgress(10);
            activity.switchFragment(R.id.fra_register_content,faceFra,accountFra,"faceFra");
        } else if (fraEnum == RegisterFraEnum.FACE) {

        } else {

        }
    }

    public void addData(LoginInfoBean.DataBean data){
        String info = SpUtil.getInstance().getStringInfo(Parameter.LOGINKEY);
        if(!info.equals(Parameter.ERROR)){
            login = new Gson().fromJson(info, LoginInfoBean.class);
            login.getList().add(0,data);
        }else{
            List<LoginInfoBean.DataBean> list=new ArrayList<>();
            list.add(data);
            login = new LoginInfoBean(list);
        }
        SpUtil.getInstance().setStringInfo(new Gson().toJson(login), Parameter.LOGINKEY);
    }

}
