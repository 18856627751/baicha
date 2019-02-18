package com.ben.jdemo.savor.bean;

import java.util.List;

/**
 * @author： BaiCha
 * @Time:2019/1/21
 * @description :
 */
public class LoginInfoBean {



    private List<DataBean> list;

    public LoginInfoBean(){}
    public LoginInfoBean(List<DataBean> list){
        this.list=list;
    }

    public List<DataBean> getList() {
        return list;
    }

    public void setList(List<DataBean> list) {
        this.list = list;
    }

    public static class DataBean{
        public String getAcount() {
            return account;
        }

        public void setAcount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFaceInfo() {
            return faceInfo;
        }

        public void setFaceInfo(String faceInfo) {
            this.faceInfo = faceInfo;
        }

        private String account;
        private String password;
        private String faceInfo;
    }
}
