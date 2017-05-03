package com.example.ldp.com.adapter;/**
 * Created by Administrator on 2017/3/23.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :AdapterUtil为 适配器基础类
 * Author:ldp
 * Data:2017/3/23
 */
public abstract  class AdapterBase<T> extends BaseAdapter {

    //定义数据
    List<T> list = new ArrayList<T>();

    //上下文
    Context context;

    //传入的是一个集合的数据的情况
    public AdapterBase(Context context, List<T> list){
        this.list = list;
        this.context = context;
    }

    //传入的是一个数组数据的情况
    //其实数组也是要转换为集合的数据，因为适配器只接受集合的数据
    public AdapterBase(Context context, T[] list) {
        this.context = context;
        for (T t : list) {
            this.list.add(t);
        }
    }

    //返回数据的总数
    @Override
    public int getCount() {
        return this.list==null?null:list.size();
    }

    //返回集合中某个游标值的对象
    @Override
    public T getItem(int position) {
        return this.list==null?null:list.get(position);
    }

    //返回选中的条目的游标值
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
