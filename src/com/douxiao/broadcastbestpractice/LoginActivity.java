package com.douxiao.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private CheckBox rememberPass;
	// 首先要声明三个按钮
	private EditText accountEdit, passwordEdit;
	private Button login;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		pref =PreferenceManager.getDefaultSharedPreferences(this);
		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		rememberPass = (CheckBox) findViewById(R.id.remember_pass);
		login = (Button) findViewById(R.id.login);
		boolean isRemember = pref.getBoolean("remember_password", false);
		if (isRemember) {
			// 将账号和密码都设置到文本框中去
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(account);
			passwordEdit.setText(password);
			rememberPass.setChecked(true);

		}

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();
				// 如果账号是admin且密码是123456,就认为登陆成功
				if (account.equals("admin") && password.equals("123456")) {
					editor = pref.edit();
					if (rememberPass.isChecked())// 检查复选框是否被选中
					{
						editor.putBoolean("remember_password", true);
						editor.putString("account", account);
						editor.putString("password", password);

					}else {
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(LoginActivity.this, "account or password is invaild", Toast.LENGTH_SHORT).show();

				}
			}
		});
	}

}
