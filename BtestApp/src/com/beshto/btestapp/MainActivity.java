package com.beshto.btestapp;

import org.jivesoftware.smack.XMPPException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.beshto.btestapp.JabberConnection;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button adminLogin;
	private EditText username;
	private EditText userpass;
	private JabberConnection jConnection;
	private String usernameST;
	private String passwordST;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		checkAdmin();

	}
	
	private void checkAdmin() {
		adminLogin = (Button) findViewById(R.id.button1);
		username = (EditText) findViewById(R.id.editText1);
		userpass = (EditText) findViewById(R.id.editText2);
		
		jConnection = new JabberConnection();

		adminLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				usernameST = username.getText().toString();
				passwordST = userpass.getText().toString();
				
				try {
					jConnection.login(usernameST, passwordST);
				} catch (XMPPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
