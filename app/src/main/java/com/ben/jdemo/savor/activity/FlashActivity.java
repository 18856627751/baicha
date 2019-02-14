package com.ben.jdemo.savor.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.base.BaseActivity;
import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.db.SpUtil;
import com.ben.jdemo.savor.util.GlideUtil;
import com.ben.jdemo.savor.util.Interfaces.TeaLogListener;
import com.ben.jdemo.savor.util.TLog;
import com.ben.jdemo.savor.util.enumstyle.StatusBar;
import com.ben.jdemo.savor.widget.TeaSvgView;

public class FlashActivity extends BaseActivity implements View.OnClickListener,TeaLogListener{


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
        bgFlash = (ImageView) findViewById(R.id.iv_splash);
        linearLayout =(RelativeLayout) findViewById(R.id.ll_time_count);
        teaLog = (TeaSvgView)findViewById(R.id.v_tea_log);
        tvTime = (TextView) findViewById(R.id.tv_time_flash);
    }

    @Override
    protected void initDeal() {
        GlideUtil.normal(this,R.mipmap.splash,bgFlash);
        linearLayout.setOnClickListener(this);
        teaLog.setListener(this);

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
        final String info = SpUtil.getInstance().getStringInfo(Parameter.LOGINKEY);
        if(time<1){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       TLog.e("FlashActivity","InterruptedException:"+e.getMessage());
                   }
                   if(!info.equals(Parameter.ERROR)){
                       startActivity(new Intent(FlashActivity.this,LoginActivity.class));
                   }else{
                       startActivity(new Intent(FlashActivity.this,RegisterActivity.class));
                   }

                   finish();
               }
           }).start();
            return;
        }

        String t=(int)time+"s";
        tvTime.setText(t);
    }
}
