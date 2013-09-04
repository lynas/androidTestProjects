package com.lynas.dialogboxtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	private Button alb;
	final Context context = this;
	final private int RESET_DIALOG=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showAlert();
	}
	public void showAlert(){
		alb = (Button) findViewById(R.id.button1);
		alb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showDialog(RESET_DIALOG);
				
				
				
			}
		});
	}
	
	protected android.app.Dialog onCreateDialog(int id){
		Dialog dialog;
		switch (id) {
		case RESET_DIALOG:
			dialog = new Dialog(this);
			dialog.setContentView(R.layout.customdialoguelayout);
			return dialog;
		}
		
		return null;
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
