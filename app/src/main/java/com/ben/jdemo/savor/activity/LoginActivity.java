package com.ben.jdemo.savor.activity;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.util.TLog;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;
import com.ben.jdemo.savor.util.pass.PassWordUtil;

public class LoginActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
