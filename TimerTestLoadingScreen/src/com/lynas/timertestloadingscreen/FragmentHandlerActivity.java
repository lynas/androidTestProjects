package com.lynas.timertestloadingscreen;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class FragmentHandlerActivity extends FragmentActivity {
	private Fragment scree1 = new Screen1();
	private Fragment scree2 = new Screen2();
	private Fragment scree3 = new Screen3();
	
	private int time = 0;
	private Button btnStop;
	private Timer t = new Timer();
	private int btnStat=0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_handler);
		
		btnStop = (Button) findViewById(R.id.btnStopTimer);
		btnStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(btnStat == 0){
					timerStart();
					btnStop.setText("Stop");
					
				}else{
					timerStop();
					btnStop.setText("Start");
				}
				
				
			}
		});
		
		
		
		

	
	
	
	}
	
	
	private void timerStart(){
		btnStat = 1;
		

		FragmentManager mainFragManager = getSupportFragmentManager();
		FragmentTransaction fragtrans = mainFragManager.beginTransaction();
		fragtrans.replace(R.id.frame1, scree1);
		fragtrans.commit();
		
		
		
		
		//Declare the timer
		
		//Set the schedule function and rate
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		        //Called each time when 1000 milliseconds (1 second) (the period parameter)
		    	//We must use this function in order to change the text view text
		    	runOnUiThread(new Runnable() {

		    	    @Override
		    	    public void run() {
		    	    	switchScreen();
		    	        time += 1;
		    	    }
		    	     
		    	});
		    }
		         
		},
		//Set how long before to start calling the TimerTask (in milliseconds)
		0,
		//Set the amount of time between each execution (in milliseconds)
		1000);
		
	}
	private void timerStop(){
		btnStat = 0;
		
		t.cancel();
		t.purge();
		
		
		
	}
	
	
	
	private void switchScreen() {
		FragmentManager mainFragManager = getSupportFragmentManager();

		FragmentTransaction fragtrans = mainFragManager.beginTransaction();

		if (time==2) {
			fragtrans.replace(R.id.frame1, scree2);
		} else if (time==4) {
			fragtrans.replace(R.id.frame1, scree3);
		}
		else if (time==6) {
			fragtrans.replace(R.id.frame1, scree1);
			time = 0;
		}
		fragtrans.addToBackStack(null);
		fragtrans.commit();
		
	}
	
	
	
	
	
	
	
	
	
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fragment_handler, menu);
		return true;
	}*/

}
