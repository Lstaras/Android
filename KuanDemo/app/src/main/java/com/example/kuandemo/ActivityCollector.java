package com.example.kuandemo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:KuanDemo
 * 创建人:Lstaras
 * 创建时间: ${DATA} 10:03
 */

//活动管理器
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
