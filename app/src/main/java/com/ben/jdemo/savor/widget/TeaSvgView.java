package com.ben.jdemo.savor.widget;

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
import android.util.AttributeSet;
import android.view.View;

import com.ben.jdemo.savor.R;
import com.ben.jdemo.savor.util.Interfaces.TeaLogListener;

import androidx.annotation.Nullable;

/**
 * @author： BaiCha
 * @Time:2019/1/17
 * @description :tea图标的动效设计
 * width:263
 */
public class TeaSvgView extends View {

    private int width;
    private int height;
    private Paint paintArc;
    private float percent = 0f;
    private TeaLogListener listener;
    private boolean destory = false;
    private ValueAnimator valueAnimator;
    private int time = 0;
    Path path = new Path();

    public TeaSvgView(Context context) {
        this(context, null);
    }

    public TeaSvgView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TeaSvgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        destory = false;
        paintArc = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintArc.setStrokeCap(Paint.Cap.ROUND);
        paintArc.setStyle(Paint.Style.STROKE);
        paintArc.setColor(Color.WHITE);
        paintArc.setAlpha(255);
        paintArc.setTextAlign(Paint.Align.CENTER);

        drawArcShow();
    }

    //绘制圆形效果
    private void drawArcShow() {
        valueAnimator = ValueAnimator.ofFloat(0, 0.8f);
        valueAnimator.setRepeatCount(0);
        valueAnimator.setDuration(5900);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                percent = (float) valueAnimator.getAnimatedValue();
                invalidate();
                if (percent == 0.8f) {
                    listener.animProgress(true, 0);
                } else {
                    if (listener != null) {
                        if (time != 6 - (int) (percent / 0.8 * 6)) {
                            time = 6 - (int) (percent / 0.8 * 6);
                            listener.animProgress(false, (float) time);
                        }
                    }
                }
            }
        });
        valueAnimator.start();

    }

    public void setListener(TeaLogListener listener) {
        if (listener != null) {
            this.listener = listener;
        }
    }

    public void drawAccelerate() {
        if (percent > 0.7) {
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.cancel();
        valueAnimator = null;
        valueAnimator = ValueAnimator.ofFloat(percent, 0.8f);
        valueAnimator.setRepeatCount(0);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                percent = (float) valueAnimator.getAnimatedValue();
                invalidate();
                if (percent == 0.8f) {
                    listener.animProgress(true, 0);
                } else {
                    if (listener != null) {
                        if (time != 6 - (int) (percent / 0.8 * 6)) {
                            time = 6 - (int) (percent / 0.8 * 6);
                            listener.animProgress(false, (float) time);
                        }

                    }
                }
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        int max=Math.min(width,height);
        width=max;
        height=max;
        setMeasuredDimension(max,max);
    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (destory) {
            return;
        }
        path.reset();
        paintArc.setTextSize(width/6);
        paintArc.setAlpha(255);
        paintArc.setStrokeWidth(percent * 20);
        canvas.drawArc(new RectF(width * 0.1f, width * 0.1f, height * 0.9f, height * 0.9f), -260 - 40 * percent, -90 - 220 * percent, false, paintArc);

        path.addArc(new RectF(width * 0.1f, width * 0.1f, height * 0.9f, height * 0.9f), -166-40*percent, -94);

        paintArc.setAlpha((int) ((0.8f + percent / 4) * 255));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tea);
        canvas.drawBitmap(bitmap, new Rect(0, 0, width, height), new RectF(width / 5, height / 5, width / 5 * 4, height / 5 * 4), paintArc);

        paintArc.setAlpha((int) ((0.2f + percent) * 255));
        paintArc.setStrokeWidth(width/66);
        canvas.drawTextOnPath("baicha", path, 0.005f * width, 0.05f * height, paintArc);

    }

    public void onDestroy() {
        valueAnimator.removeAllUpdateListeners();
        destory = true;
    }


}
