package com.example.ldp.com.adapter;/**
 * Created by Administrator on 2017/3/23.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ldp.com.forestteaching.R;

import java.util.List;

/**
 * Description :Myadater为 类
 * Author:ldp
 * Data:2017/3/23
 */
public class Student_Evaluate_Adater extends ArrayAdapter<String> {

    private int resourceId;//布局子项ID

    public Student_Evaluate_Adater(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView用于将之前加载好的布局进行缓存，以便可以重用
        String str = getItem(position);//获取当前的Course实例
        View view;
        ViewHolder viewholder;
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewholder = new ViewHolder();
            viewholder.questionName = (TextView)view.findViewById(R.id.question_id);
            view.setTag(viewholder);//将viewHolder存储在View中
        }else{
            view = convertView;//所以当不为空的时候就重用，深化性能
            viewholder = (ViewHolder) view.getTag();//重新获取ViewHolder
        }
        viewholder.questionName.setText(str);
        return view;
    }

    class ViewHolder{
        /*第一步是缓存布局converView,第二步是缓存控件，当这个布局存在的情况下
        ，自然其中的控件也存在就不用每次都通过findViewById来找实例了，通过这两步实现这个ListView性能优化*/
        TextView questionName;
    }
}
