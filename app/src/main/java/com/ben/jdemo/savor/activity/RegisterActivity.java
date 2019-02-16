package com.ben.jdemo.savor.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.fragments.RegisterNumFra;
import com.ben.jdemo.savor.util.Interfaces.RegisterViewFinish;
import com.ben.jdemo.savor.util.enumstyle.RegisterFraEnum;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity implements RegisterViewFinish {

    long keyBack = 0;
    RegisterFraEnum fraEnum;

    @BindView(R.id.bt_next_step)
    Button btNextStep;
    private RegisterNumFra accountFra;

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
        ButterKnife.bind(this);
        Toast.makeText(this, "客官还没有账号，注册一个吧（>.<）", Toast.LENGTH_SHORT).show();

        accountFra = new RegisterNumFra();
        addFragment(R.id.fra_register_content,accountFra, "register");

        fraEnum=RegisterFraEnum.ACCOUNT;
    }

    @Override
    protected void initDeal() {
        btNextStep.setOnClickListener(v -> {
            if(fraEnum==RegisterFraEnum.ACCOUNT){
                accountFra.setOnClick();
            }else if(fraEnum==RegisterFraEnum.FACE){

            }else{

            }
        });
    }

    //注册进度条完全结束
    @Override
    public void finishView() {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (System.currentTimeMillis() - keyBack > 1000) {
            keyBack = System.currentTimeMillis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
