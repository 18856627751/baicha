package com.ben.jdemo.savor.fragments;

import android.view.View;
import android.widget.Toast;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseFragment;
import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.mvp.model.modleinterface.RegisterAccountListener;
import com.ben.jdemo.savor.mvp.presenters.RegisterPresenter;
import com.ben.jdemo.savor.mvp.view.RegisterNumFraIView;
import com.ben.jdemo.savor.util.enumstyle.RegisterFraEnum;
import com.ben.jdemo.savor.widget.AccountEditText;
import com.ben.jdemo.savor.widget.PassEditText;

import java.util.Objects;

/**
 * @author:  BaiCha
 * @Time: 2019/1/24
 * @description :
 */
public class RegisterNumFra extends BaseFragment implements RegisterNumFraIView,
        RegisterAccountListener{

    private AccountEditText account;
    private PassEditText pass;
    private RegisterPresenter presenter;

    //7dc5eb
    @Override
    protected void init(View view) {
        account = view.findViewById(R.id.register_account);
        pass = view.findViewById(R.id.register_pass);
        presenter = new RegisterPresenter(this, this);
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
                Objects.requireNonNull(pass.getText()).toString());
    }





    @Override
    public void setAccountErrorStyle() {

    }

    @Override
    public void setPassErrorStyle() {

    }

    @Override
    public void step(RegisterFraEnum en) {

    }

    /**
     * account register
     */
    @Override
    public void accountEmpty() {
        Toast.makeText(getActivity(), "account null", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passEmpty() {
        Toast.makeText(getActivity(), "pass null", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void accountLengthShort() {
        Toast.makeText(getActivity(), "account short", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void passLengthShort() {
        Toast.makeText(getActivity(), "pass short", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void nextStep(LoginInfoBean.DataBean data) {
        Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();

    }


}
