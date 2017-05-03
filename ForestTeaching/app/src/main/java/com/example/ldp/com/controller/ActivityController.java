package com.example.ldp.com.controller;/**
 * Created by Administrator on 2017/3/27.
 */

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :ActivityController为 活动集中管理类
 * Author:ldp
 * Data:2017/3/27
 */
public class ActivityController {

    public static List<Activity> activities = new ArrayList<>();

    /*将活动类加入集中管理器中*/
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /*将活动类从集中管理器中移除*/
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /*清除所有活动*/
    public static void finishAll(){

        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
