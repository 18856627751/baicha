package com.ben.jdemo.savor.mvp.view;

/**
 * @author： BaiCha
 * @Time:2019/1/24
 * @description :
 */
public interface RegisterNumView {
    void showProgress();

    void hideProgress();

    void setAccountErrorStyle();

    void setPassErrorStyle();

    void navigateToHome();
}
