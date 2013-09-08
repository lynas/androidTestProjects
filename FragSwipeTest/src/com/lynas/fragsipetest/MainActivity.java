package com.lynas.fragsipetest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends TabSwipeActivity {
	
	Button go;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		go = (Button) findViewById(R.id.button1);
		
		go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Intent fh = new Intent(MainActivity.this, FragHandler.class);
				//startActivity(fh);
				addTab(R.drawable.ic_launcher, "HELLO", TestFrag1.class, null);
				addTab(R.drawable.ic_launcher, "HELLO", TestFrag2.class, null);
				
				
			}
		});
	}



}
