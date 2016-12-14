package com.douxiao.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * 该类用于管理所有的活动
 * @author Administrator
 *
 */
public class ActivityCollector {
	private static List<Activity> activities = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	public static void  finshAll() {
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
