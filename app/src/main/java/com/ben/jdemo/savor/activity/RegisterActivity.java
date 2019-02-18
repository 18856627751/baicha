package com.ben.jdemo.savor.activity;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.ben.jdemo.savor.mvp.presenters.RegisterPresenter;
import com.ben.jdemo.savor.util.Interfaces.RegisterViewFinish;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;
import com.ben.jdemo.savor.widget.RegisterProgress;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity implements RegisterViewFinish {

    long keyBack = 0;

    @BindView(R.id.bt_next_step)
    Button btNextStep;
    @BindView(R.id.rp_progress_tea)
    RegisterProgress rpProgressTea;

    private LoginInfoBean.DataBean data;
    private RegisterPresenter presenter;


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
        EventBus.getDefault().register(this);
        presenter = new RegisterPresenter(this);
        presenter.initFragment();
    }

    @Override
    protected void initDeal() {
        btNextStep.setOnClickListener(v -> presenter.setOnClick(v,rpProgressTea));
    }

    //注册进度条完全结束
    @Override
    public void finishView() {
        presenter.addData(data);
        //startActivity
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyBack == 0) {
            Toast.makeText(this, "双击退出", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (System.currentTimeMillis() - keyBack > 1000) {
            keyBack = System.currentTimeMillis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void registerFras(LoginInfoBean.DataBean data) {
        this.data = data;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
