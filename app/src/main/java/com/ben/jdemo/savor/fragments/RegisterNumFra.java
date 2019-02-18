package com.ben.jdemo.savor.fragments;

import android.view.View;
import android.widget.Toast;
import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseFragment;
import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.mvp.model.modleinterface.RegisterAccountListener;
import com.ben.jdemo.savor.mvp.presenters.RegisterFraPresenter;
import com.ben.jdemo.savor.widget.AccountEditText;
import com.ben.jdemo.savor.widget.PassEditText;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

/**
 * @author:  BaiCha
 * @Time: 2019/1/24
 * @description :
 */
public class RegisterNumFra extends BaseFragment implements RegisterAccountListener{

    private AccountEditText account;
    private PassEditText pass;
    private RegisterFraPresenter presenter;

    //7dc5eb
    @Override
    protected void init(View view) {
        account = view.findViewById(R.id.register_account);
        pass = view.findViewById(R.id.register_pass);
        presenter = new RegisterFraPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fra_register_number;
    }


    public void setOnClick(){
        presenter.setFraAccountModel(
                Objects.requireNonNull(account.getText()).toString(),
                Objects.requireNonNull(pass.getText()).toString(),this);
    }



    /**
     * account register
     */
    @Override
    public void accountEmpty() {
        Toast.makeText(getActivity(), "帐号不能为空-_-||", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passEmpty() {
        Toast.makeText(getActivity(), "密码不能为空-_-||", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void accountLengthShort() {
        Toast.makeText(getActivity(), "帐号不能低于6位", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void accountExist() {
        Toast.makeText(getActivity(), "帐号已经存在", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passLengthShort() {
        Toast.makeText(getActivity(), "密码不能低于6位", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void nextStep(LoginInfoBean.DataBean data) {
        EventBus.getDefault().post(data);
    }


}
