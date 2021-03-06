package com.ben.jdemo.savor.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE;

/**
 * @author： BaiCha
 * @Time:2019/1/14
 * @description :
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        styleSetting();
        setContentView(getLayoutId());

        initial();
        initDeal();

    }

    protected abstract int getLayoutId();

    protected abstract StatusBar getStatusBarStyle();

    protected abstract void initial();

    protected abstract void initDeal();


    //状态栏的样式
    private void styleSetting(){
        if(getStatusBarStyle()== StatusBar.HIDE){
            if(Build.VERSION.SDK_INT >= 21){
                View viewDoctor = getWindow().getDecorView();
                int option =View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | SYSTEM_UI_FLAG_IMMERSIVE;
                viewDoctor.setSystemUiVisibility(option);
                //设置状态栏和导航栏颜色为透明
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().setNavigationBarColor(Color.TRANSPARENT);
            }
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏状态栏
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        }else if(getStatusBarStyle()==StatusBar.TRANSPARENT) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);

            }


        }
    }

    public void setColorBar(@ColorInt int color, int alpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int alphaColor = alpha == 0 ? color : calculateColor(color, alpha);
            window.setStatusBarColor(alphaColor);
            window.setNavigationBarColor(alphaColor);
        }

    }


    private int calculateColor(@ColorInt int color, int alpha) {
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }


    public void addFragment(int containerViewId, Fragment fragment, String tag) {
        try {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (!fragment.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                ft.add(containerViewId, fragment, tag);
            } else {
                // 隐藏当前的fragment，显示下一个
                ft.show(fragment);
            }
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchFragment(int containerViewId, Fragment show, Fragment hide, String tag) {
        try {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // 隐藏当前的fragment，add下一个到Activity中
            if (!show.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.hide(hide).add(containerViewId, show, tag);
            } else {
                // 隐藏当前的fragment，显示下一个
                transaction.hide(hide).show(show);
            }
            transaction.addToBackStack(tag);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replaceFragment(int containerViewId, Fragment show, String tag) {
        try {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            // 隐藏当前的fragment，add下一个到Activity中
            if (!show.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.add(containerViewId, show, tag);
            } else {
                // 隐藏当前的fragment，显示下一个
                transaction.replace(containerViewId,show,tag);
            }
            transaction.addToBackStack(tag);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
