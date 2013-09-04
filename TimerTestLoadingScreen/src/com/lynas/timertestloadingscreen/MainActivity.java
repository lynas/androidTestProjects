package com.lynas.timertestloadingscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	public int time = 0;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		

		b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent fhIntent = new Intent(MainActivity.this, FragmentHandlerActivity.class);
				startActivity(fhIntent);
				
				
			}
		});
		
		/*
		//Declare the timer
		Timer t = new Timer();
		//Set the schedule function and rate
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		        //Called each time when 1000 milliseconds (1 second) (the period parameter)
		    	//We must use this function in order to change the text view text
		    	runOnUiThread(new Runnable() {

		    	    @Override
		    	    public void run() {
		    	        TextView tv = (TextView) findViewById(R.id.textView2);
		    	        tv.setText(String.valueOf(time));
		    	        time += 1;
		    	    }
		    	     
		    	});
		    }
		         
		},
		//Set how long before to start calling the TimerTask (in milliseconds)
		0,
		//Set the amount of time between each execution (in milliseconds)
		3000);
		*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
