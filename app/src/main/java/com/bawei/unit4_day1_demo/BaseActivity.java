package com.bawei.unit4_day1_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 功能：BaseActivity类
 * 作者：武柯耀
 * 当前日期：2019/11/1
 * 当前时间：19:11
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(providerLayoutId());
      initView();
      initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int providerLayoutId();
}
