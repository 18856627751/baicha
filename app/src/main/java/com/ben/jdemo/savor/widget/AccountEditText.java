package com.ben.jdemo.savor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.ben.jdemo.savor.R;

/**
 * @author： BaiCha
 * @Time:2019/1/24
 * @description :
 */
public class AccountEditText extends AppCompatEditText implements View.OnFocusChangeListener {

    private Drawable drawable;
    private Context context;
    private EditText edit;
    private boolean focused = false;

    public AccountEditText(Context context) {
        this(context, null);
    }

    public AccountEditText(Context context, AttributeSet attrs) {
        this(context,attrs, android.R.attr.editTextStyle);
    }

    @SuppressLint("CustomViewStyleable")
    public AccountEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EditDelete);
        drawable = typedArray.getDrawable(R.styleable.EditDelete_delSre);
        setOnFocusChangeListener(this);
        typedArray.recycle();
        initDeal();
    }

    private void initDeal() {
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(context, R.mipmap.delete);

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
                setDrawable();
            }
        });
    }

    private void setDrawable() {
        if (length() <= 0 ) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            drawable.setBounds(0, 0, Dp2Px(15), Dp2Px(15));
            setCompoundDrawables(null, null, drawable, null);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        this.focused = b;
//        if (focused && length() > 0) {
//            drawable.setBounds(0, 0, Dp2Px(15), Dp2Px(15));
//            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
//        } else {
//            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
//        }

    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        this.focused = focused;
//        if (focused && length() > 0) {
//            drawable.setBounds(0, 0, Dp2Px(15), Dp2Px(15));
//            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
//        } else {
//            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
//        }
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
                setText("");
                if (edit != null)
                    edit.setText("");
            }
        }

        return super.onTouchEvent(event);
    }

    public void setTmpEditText(EditText editText) {
        this.edit = editText;
    }

}
