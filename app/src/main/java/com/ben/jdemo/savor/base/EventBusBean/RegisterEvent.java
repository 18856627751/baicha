package com.ben.jdemo.savor.base.EventBusBean;

import com.ben.jdemo.savor.bean.LoginInfoBean;

/**
 * @author: BaiCha
 * @Time: ---2019/2/17---
 * @description:
 */
public class RegisterEvent {
    public LoginInfoBean.DataBean data;

    public LoginInfoBean.DataBean getData() {
        return data;
    }

    public RegisterEvent(LoginInfoBean.DataBean data) {
        this.data = data;
    }
}
