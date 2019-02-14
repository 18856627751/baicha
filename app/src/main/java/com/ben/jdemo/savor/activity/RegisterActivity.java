package com.ben.jdemo.savor.activity;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.util.Interfaces.RegisterViewFinish;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

public class RegisterActivity extends BaseActivity implements RegisterViewFinish{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected StatusBar getStatusBarStyle() {
        return StatusBar.HIDE;
    }

    @Override
    protected void initial() {

    }

    @Override
    protected void initDeal() {

    }

    //注册进度条完全结束
    @Override
    public void finishView() {

    }
}
