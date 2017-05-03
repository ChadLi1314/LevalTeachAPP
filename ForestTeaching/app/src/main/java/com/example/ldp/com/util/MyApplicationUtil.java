package com.example.ldp.com.util;

import android.app.Application;
import android.content.Context;

/**
 * Time:2017年3月18日 星期六
 * authod:ldp
 * Application Public Method
 * Created by Administrator on 2017/3/18.
 */

public class MyApplicationUtil extends Application{

    private static Context context;
    @Override
    public void onCreate() {
        this.context = getApplicationContext();

    }

    public static Context getContext(){
        return context;
    }
   /* intent.putExtra("person_data",person);//这里的person对象已经序列化，
    Person person = (Person)getIntent().getSerializableExtra("person_data");即可*/
}
