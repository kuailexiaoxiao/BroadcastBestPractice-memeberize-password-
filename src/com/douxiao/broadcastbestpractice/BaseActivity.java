package com.douxiao.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;
//����BaseActivity��Ϊ���л�ĸ���
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
