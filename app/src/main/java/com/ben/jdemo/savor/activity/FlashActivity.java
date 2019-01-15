package com.ben.jdemo.savor.activity;

import android.view.View;
import android.widget.ImageView;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.mvp.view.FlashIVIew;
import com.ben.jdemo.savor.util.GlideUtil;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

public class FlashActivity extends BaseActivity implements FlashIVIew{


    private ImageView bgFlash;

    @Override
    public int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    protected StatusBar getStatusBarStyle() {
        return StatusBar.HIDE;
    }

    @Override
    protected void initial() {
        bgFlash = findViewById(R.id.iv_splash);
    }

    @Override
    protected void initDeal() {
        GlideUtil.normal(this,R.mipmap.splash,bgFlash);
    }

    @Override
    public void startTime() {

    }

    @Override
    public void finshTime() {

    }
}
