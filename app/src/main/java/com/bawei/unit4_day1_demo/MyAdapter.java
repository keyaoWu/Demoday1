package com.bawei.unit4_day1_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 功能：MyAdapter类
 * 作者：武柯耀
 * 当前日期：2019/11/1
 * 当前时间：19:40
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ListdataBean> list;

    public MyAdapter(Context context, List<Bean.ListdataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHoleder viewHoleder;
        if (view == null){
         view = LayoutInflater.from(context).inflate(R.layout.item,null);
         viewHoleder = new ViewHoleder();
         viewHoleder.imageView = view.findViewById(R.id.image);
         viewHoleder.name = view.findViewById(R.id.name);
         view.setTag(viewHoleder);
        }else {
            viewHoleder = (ViewHoleder) view.getTag();
        }
        viewHoleder.name.setText(list.get(i).getName());
        NetUntil.getInstance().doGetPhoto(list.get(i).getAvatar(), new NetUntil.myCallBack() {
            @Override
            public void onDoGetSuccess(String json) {

            }

            @Override
            public void onDoGetPhotoSuccess(Bitmap bitmap) {
          viewHoleder.imageView.setImageBitmap(bitmap);
            }
        });
        return view;
    }
    class  ViewHoleder{
        ImageView imageView;
        TextView name;
    }
}
