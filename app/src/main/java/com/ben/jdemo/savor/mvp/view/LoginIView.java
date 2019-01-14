package com.ben.jdemo.savor.mvp.view;

/**
 * @author： BaiCha
 * @Time:2019/1/14
 * @description :登录view
 */
public interface LoginIView {
    void showProgress();
    void hideProgress();
    void loginError();
    void loginSuccess();
}
