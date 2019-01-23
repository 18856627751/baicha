package com.ben.jdemo.savor.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.mvp.view.FlashIVIew;
import com.ben.jdemo.savor.util.GlideUtil;
import com.ben.jdemo.savor.util.Interfaces.TeaLogListener;
import com.ben.jdemo.savor.util.TLog;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;
import com.ben.jdemo.savor.widget.TeaSvgView;

public class FlashActivity extends BaseActivity implements FlashIVIew ,View.OnClickListener,TeaLogListener{


    private int TimeCount=5;
    private ImageView bgFlash;
    private RelativeLayout linearLayout;
    private TeaSvgView teaLog;
    private TextView tvTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    protected StatusBar getStatusBarStyle() {
        return StatusBar.HIDE;
    }

    @Override
    protected void initial() {
        bgFlash = findViewById(R.id.iv_splash);
        linearLayout = findViewById(R.id.ll_time_count);
        teaLog = findViewById(R.id.v_tea_log);
        tvTime = findViewById(R.id.tv_time_flash);
    }

    @Override
    protected void initDeal() {
        GlideUtil.normal(this,R.mipmap.splash,bgFlash);
        linearLayout.setOnClickListener(this);
        teaLog.setListener(this);

    }

    @Override
    public void startTime() {

    }

    @Override
    public void finishTime() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        teaLog.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_time_count:
                teaLog.drawAccelerate();
                break;
        }
    }


    @Override
    public void animProgress(boolean isFinish, float time) {

        if(time<1){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       TLog.e("FlashActivity","InterruptedException:"+e.getMessage());
                   }
                   startActivity(new Intent(FlashActivity.this,LoginActivity.class));
                   finish();
               }
           }).start();
            return;
        }

        String t=(int)time+"s";
        tvTime.setText(t);
    }
}
