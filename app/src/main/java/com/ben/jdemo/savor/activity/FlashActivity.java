package com.ben.jdemo.savor.activity;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

public class FlashActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    protected StatusBar getStatusBarStyle() {
        return StatusBar.TRANSPARENT;
    }

    @Override
    protected void initial() {

    }
}
