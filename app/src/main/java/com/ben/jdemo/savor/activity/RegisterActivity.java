package com.ben.jdemo.savor.activity;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

public class RegisterActivity extends BaseActivity {


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
}
