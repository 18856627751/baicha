package com.ben.jdemo.savor.mvp.model;

import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.google.gson.Gson;

/**
 * @author： BaiCha
 * @Time:2019/1/23
 * @description :
 */
public class LoginModle {

    public interface LoginModelListener{
        void accountEmpty();
        void passEmpty();
        void faceError();
        void inExistence();
        void passWordError();
        void passMissingMacth();
    }

    public void login(String account,String pass,String faceID,LoginModelListener listener){

    }
}
