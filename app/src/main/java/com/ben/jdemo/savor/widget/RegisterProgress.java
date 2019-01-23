package com.ben.jdemo.savor.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.util.Interfaces.RegisterViewFinish;

/**
 * @author： BaiCha
 * @Time:2019/1/23
 * @description :注册界面进度条绘制
 * width:1080
 */
public class RegisterProgress extends View {

    private int max;
    private Paint paint;
    private Paint paintBorder;
    private Path path;
    private Path pathText;
    private Path pathText2;
    private Paint paintText;
    private float progress=1; //进度最大为150 (默认15一个单位)
    private RegisterViewFinish listener;


    public RegisterProgress(Context context) {
        this(context,null);
    }

    public RegisterProgress(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RegisterProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getResources().getColor(R.color.deepGreen));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);

        paintBorder = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBorder.setColor(Color.BLACK);
        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setStrokeCap(Paint.Cap.SQUARE);


        path = new Path();
        pathText = new Path();
        pathText2 = new Path();

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(getResources().getColor(R.color.deepGray));
        paintText.setStyle(Paint.Style.STROKE);

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(getResources().getColor(R.color.deepGray));
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setStrokeCap(Paint.Cap.ROUND);

        setProgress(0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        max=Math.min(width,height);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //corner
        setCornerDraw(canvas);
        //progress
        borderAndProgress(canvas);
        //tea
        teaDraw(canvas);

    }

    private void setCornerDraw(Canvas canvas) {
        paintBorder.setColor(getResources().getColor(R.color.deepGray));
        paintBorder.setStrokeWidth(max/216);
        paintBorder.setStyle(Paint.Style.STROKE);

        path.reset();
        path.addArc(new RectF(0.05f*max,0.05f*max,0.95f*max,0.95f* max),150,-40);
        path.lineTo(0.361f*max,0.88f* max);
        path.addArc(new RectF(0.03f*max,0.03f*max,0.97f*max,0.97f* max),170,-50);
        path.lineTo(0.295f*max,0.84f* max);

        path.addArc(new RectF(0.05f*max,0.05f*max,0.95f*max,0.95f* max),30,40);
        path.lineTo(0.639f*max,0.88f* max);
        path.addArc(new RectF(0.03f*max,0.03f*max,0.97f*max,0.97f* max),10,50);
        path.lineTo(0.705f*max,0.84f* max);

        canvas.drawPath(path,paintBorder);

        //绘制文字
        pathText.reset();
        pathText2.reset();
        paintText.setTextSize((float) max/15);
        pathText.addArc(new RectF(0.06f*max,0.06f*max,0.94f*max,0.94f* max),210,40);
        canvas.drawTextOnPath("baicha",pathText,0,0,paintText);
        pathText2.addArc(new RectF(0.06f*max,0.06f*max,0.94f*max,0.94f* max),290,40);
        canvas.drawTextOnPath("baicha",pathText2,0,0,paintText);

    }


    private void borderAndProgress(Canvas canvas) {
        //边框
        paintBorder.setStrokeWidth(max/24);
        paintBorder.setColor(getResources().getColor(R.color.deepGray));
        paintBorder.setStyle(Paint.Style.STROKE);

        RectF rectFBorder = new RectF(0.1f * max, 0.1f * max, 0.9f * max, 0.9f * max);
        canvas.drawArc(rectFBorder,110,155,false,paintBorder);
        canvas.drawArc(rectFBorder,275,155,false,paintBorder);

        //填充
        paintBorder.setStrokeWidth((float) (max/24.5));
        paintBorder.setColor(Color.WHITE);
        RectF rectF = new RectF(0.1f * max, 0.1f * max, 0.9f * max, 0.9f * max);
        canvas.drawArc(rectF,110,155,false,paintBorder);
        canvas.drawArc(rectF,275,155,false,paintBorder);


        //progress
        paint.setStrokeWidth(max/36);
        RectF rectFWorld = new RectF(0.1f * max, 0.1f * max, 0.9f * max, 0.9f * max);
        canvas.drawArc(rectFWorld,110,progress*15,false,paint);
        canvas.drawArc(rectFWorld,280+150-15*progress,15*progress,false,paint);
    }


    private void teaDraw(Canvas canvas) {

        paintBorder.setStyle(Paint.Style.FILL);
        paintBorder.setColor(Color.WHITE);
        canvas.drawCircle(0.5f * max,0.1f * max,0.08f * max,paintBorder);
        paintBorder.setStyle(Paint.Style.STROKE);


        //茶叶图标样式
        int teaType ;
        if(progress>=6){
            teaType = R.mipmap.greantea;
        }else{
            teaType = R.mipmap.graytea;
        }

        paintBorder.setStrokeWidth(max/90);
        paintBorder.setColor(getResources().getColor(R.color.deepGray));
        canvas.drawCircle(0.5f * max,0.1f * max,0.08f * max,paintBorder);

        Rect rectTea = new Rect(0, 0, max, max);
        RectF rectFTea = new RectF(0.43f * max, 0.03f * max, 0.57f * max, 0.17f * max);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), teaType);
        canvas.drawBitmap(bitmap,rectTea,rectFTea,new Paint());


    }

    public void setFinishListener(RegisterViewFinish listener){
        this.listener=listener;
    }

    public void setProgress(int pro){
        if(pro==0){
            progress=0;
            pro=1;
        }
        if(pro>10||pro<0){
            return;
        }
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(progress,pro);
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.setDuration(1500);
        valueAnimator.setRepeatCount(0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progress= (float) valueAnimator.getAnimatedValue();
                invalidate();

            }
        });

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if(progress==10&&listener!=null){
                    listener.finish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        valueAnimator.start();

    }

}