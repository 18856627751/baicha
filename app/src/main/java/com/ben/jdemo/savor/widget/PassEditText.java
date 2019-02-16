package com.ben.jdemo.savor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.ben.jdemo.savor.R;

/**
 * @author: BaiCha
 * @Time: ---2019/1/27---
 * @description: na=
 */
@SuppressLint("AppCompatCustomView")
public class PassEditText extends AppCompatEditText implements View.OnFocusChangeListener{


    private Drawable drawable;
    private Context context;
    private boolean isVisibility = false;

    public PassEditText(Context context) {
        this(context,null);
    }

    public PassEditText(Context context, AttributeSet attrs) {
        this(context,attrs, android.R.attr.editTextStyle);
    }

    public PassEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        @SuppressLint("CustomViewStyleable") TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditPassLook);
        drawable = typedArray.getDrawable(R.styleable.EditPassLook_LookSre);
        typedArray.recycle();
        initDeal();
    }


    private void initDeal() {
        if (drawable == null) {
            setDrawable();
        }

        setOnFocusChangeListener(this);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (length() <= 0) {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    drawable.setBounds(0, 0, Dp2Px(15), Dp2Px(15));
                    setCompoundDrawables(null, null, drawable, null);
                }

            }
        });
    }

    private void setDrawable() {
        if(!isVisibility){
            drawable = ContextCompat.getDrawable(context, R.mipmap.close_eye);
            setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            drawable = ContextCompat.getDrawable(context, R.mipmap.open_eye);
            setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
        }
        if (length() <= 0) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            drawable.setBounds(0, 0, Dp2Px(15), Dp2Px(15));
            setCompoundDrawables(null, null, drawable, null);
        }

        this.isVisibility=!isVisibility;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void onFocusChange(View view, boolean b) {
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

    }

    private int Dp2Px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (drawable != null && event.getAction() == MotionEvent.ACTION_UP) {
            int x = (int) event.getX();
            //判断触摸点是否在水平范围内
            boolean isInnerWidth = (x > (getWidth() - getTotalPaddingRight())) && (x < (getWidth() - getPaddingRight()));
            //获取删除图标的边界，返回一个Rect对象
            Rect rect = drawable.getBounds();
            //获取删除图标的高度
            int height = rect.height();
            int y = (int) event.getY();
            //计算图标底部到控件底部的距离
            int distance = (getHeight() - height) / 2;
            //判断触摸点是否在竖直范围内(可能会有点误差)
            //触摸点的纵坐标在distance到（distance+图标自身的高度）之内，则视为点中删除图标
            boolean isInnerHeight = (y > distance) && (y < (distance + height));
            if (isInnerWidth && isInnerHeight) {
                setDrawable();
                setSelection(length());
            }
        }

        return super.onTouchEvent(event);
    }


}
