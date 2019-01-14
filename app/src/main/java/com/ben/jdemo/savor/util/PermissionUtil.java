package com.ben.jdemo.savor.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.ben.jdemo.savor.constant.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： BaiCha
 * @Time:2019/1/14
 * @description :动态设置权限
 */
public class PermissionUtil {
    private static String[] permissions=new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static boolean obtainExternal(Activity activity){
        List<String> listPermissions=new ArrayList<>();
        for (String permission : permissions) {
            if(ContextCompat.checkSelfPermission(activity,permission)!= PackageManager.PERMISSION_GRANTED){
                listPermissions.add(permission);
            }
        }

        //已经都授予了权限
        if(listPermissions.isEmpty()){
            return false;
        }else{
            String[] permissionsCheck= listPermissions.toArray(new String[listPermissions.size()]);
            ActivityCompat.requestPermissions(activity,permissionsCheck, Parameter.permissionRequestCode);
           return true;
        }

    }
}
