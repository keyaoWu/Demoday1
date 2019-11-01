package com.bawei.unit4_day1_demo;

/**
 * @ActivityName: MainActivity
 * @Description: Activity介绍
 * @author: 武柯耀
 * @date: 2019/11/1
 */

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {


    private GridView gridView;

    @Override
    protected void initData() {
      if (NetUntil.getInstance().hasNet(this)){
          getdata();
      }else {
          Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
      }

    }



    @Override
    protected void initView() {
      //获取控件
        gridView = findViewById(R.id.grid);
    }

    private void getdata() {
     NetUntil.getInstance().doGet("http://blog.zhaoliang5156.cn/api/news/lawyer.json", new NetUntil.myCallBack() {
         @Override
         public void onDoGetSuccess(String json) {
             //解析
             List<Bean.ListdataBean> list = new Gson().fromJson(json, Bean.class).getListdata();
             Log.e("myMessage",""+list);
             //设置适配器
             MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
             gridView.setAdapter(myAdapter);
         }

         @Override
         public void onDoGetPhotoSuccess(Bitmap bitmap) {

         }
     });
    }
    @Override
    protected int providerLayoutId() {
        return R.layout.activity_main;
    }
}
