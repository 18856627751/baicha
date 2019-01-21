package com.ben.jdemo.savor.util;

import com.ben.jdemo.savor.bean.LoginInfoBean;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.google.gson.Gson;

/**
 * @author： BaiCha
 * @Time:2019/1/21
 * @description : 密码匹配
 */
public class LoginPassDeal {

    public void match(String info){
        String stringInfo = SpUtil.getInstance().getStringInfo(Parameter.LOGINKEY);
        if(stringInfo.equals(Parameter.ERROR)){
            //TODO 未获取到数据
        }

        LoginInfoBean infoBean = new Gson().fromJson(info, LoginInfoBean.class);
    }

}
