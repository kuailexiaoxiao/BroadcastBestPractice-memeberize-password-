package com.douxiao.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	//����Ҫ����������ť
	private EditText accountEdit,passwordEdit;
	private Button login;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		accountEdit  = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		login        = (Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String account = accountEdit.getText().toString();
				String password =passwordEdit.getText().toString();
				//����˺���admin��������123456,����Ϊ��½�ɹ�
				if(account.equals("admin")&&password.equals("123456"))
				{
			      Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			      startActivity(intent);
			      finish();
				}
				else{
					Toast.makeText(LoginActivity.this,"account or password is invaild",
							Toast.LENGTH_SHORT).show();
					
					
				}
			}
		});
	}


	
	
	
	
	
	
	
	
	
	
	
	

}