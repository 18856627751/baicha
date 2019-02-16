package com.ben.jdemo.savor.mvp.view;

import com.ben.jdemo.savor.util.enumstyle.RegisterFraEnum;

/**
 * @author： BaiCha
 * @Time:2019/1/24
 * @description :
 */
public interface RegisterNumFraIView {

    void setAccountErrorStyle();

    void setPassErrorStyle();

    void step(RegisterFraEnum en);
}
