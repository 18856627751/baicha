package com.ben.jdemo.savor.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author： BaiCha
 * @Time:2019/1/24
 * @description :
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),getLayoutId(),null);
        init(view);
        return view;
    }

    //初始化
    protected abstract void init(View view);

    protected abstract int getLayoutId();
}
