package com.ben.jdemo.savor.activity;



import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.util.PermissionUtil;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;

import androidx.annotation.NonNull;

public class MainActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected StatusBar getStatusBarStyle() {
        return null;
    }

    public void init(){

    }


    @Override
    protected void initial() {
        boolean obtainExternal = PermissionUtil.obtainExternal(this);
        if(!obtainExternal){
            init();
        }
    }

    @Override
    protected void initDeal() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== Parameter.permissionRequestCode){
            init();
        }
    }
}
