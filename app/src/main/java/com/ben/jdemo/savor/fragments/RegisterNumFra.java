package com.ben.jdemo.savor.fragments;

import android.view.View;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseFragemnt;
import com.ben.jdemo.savor.mvp.view.RegisterNumView;

/**
 * @author： BaiCha
 * @Time:2019/1/24
 * @description :
 */
public class RegisterNumFra extends BaseFragemnt implements RegisterNumView {
    @Override
    protected void init(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fra_register_number;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setAccountErrorStyle() {

    }

    @Override
    public void setPassErrorStyle() {

    }

    @Override
    public void navigateToHome() {

    }
}
