package com.douxiao.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;
//创建BaseActivity作为所有活动的父类
public class BaseActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
	}
	protected void onDestory() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
