package com.ben.jdemo.savor.mvp.model.modleinterface;

import com.ben.jdemo.savor.bean.LoginInfoBean;

/**
 * @author: BaiCha
 * @Time: ---2019/2/16---
 * @description:
 */
public interface RegisterAccountListener {

    void accountEmpty();

    void passEmpty();

    void accountLengthShort();

    void passLengthShort();

    void nextStep(LoginInfoBean.DataBean data);
}
