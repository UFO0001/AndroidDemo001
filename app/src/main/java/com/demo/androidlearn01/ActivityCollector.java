package com.demo.androidlearn01;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THF on 17/5/3.
 * 管理活动类
 */

public class ActivityCollector {
    public static List<Activity> activities  = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity : activities){//遍历Activity
            if(!activity.isFinishing()){//如果没有完成
                activity.finish();
            }
        }
    }
}
