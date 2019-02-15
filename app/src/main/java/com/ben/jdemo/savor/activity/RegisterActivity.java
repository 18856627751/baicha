package com.ben.jdemo.savor.activity;

import android.view.KeyEvent;
import android.widget.Toast;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.fragments.RegisterNumFra;
import com.ben.jdemo.savor.util.Interfaces.RegisterViewFinish;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

import androidx.fragment.app.Fragment;

public class RegisterActivity extends BaseActivity implements RegisterViewFinish{

    long keyBack=0;

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

        addFragment(R.id.fra_register_content,new RegisterNumFra(),"register");
    }

    @Override
    protected void initDeal() {

    }

    //注册进度条完全结束
    @Override
    public void finishView() {

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(System.currentTimeMillis()-keyBack>1000){
            keyBack=System.currentTimeMillis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
