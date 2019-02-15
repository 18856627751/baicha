package com.ben.jdemo.savor.activity;

import android.widget.Toast;

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
        Toast.makeText(this, "客官还没有账号，注册一个吧（>.<）", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initDeal() {

    }

    //注册进度条完全结束
    @Override
    public void finishView() {

    }
}
