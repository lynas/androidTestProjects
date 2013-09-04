package com.lynas.swipetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {
	private boolean isTouch = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {

	int X = (int) event.getX();
	int Y = (int) event.getY();

	int eventaction = event.getAction();

	switch (eventaction) {

	case MotionEvent.ACTION_DOWN:

	    Toast.makeText(this, "ACTION_DOWN AT COORDS "+"X: "+X+" Y: "+Y,             Toast.LENGTH_SHORT).show();

	    isTouch = true;
	    break;

	case MotionEvent.ACTION_MOVE:

	    Toast.makeText(this, "MOVE "+"X: "+X+" Y: "+Y, Toast.LENGTH_SHORT).show();

	    break;

	case MotionEvent.ACTION_UP:

	    Toast.makeText(this, "ACTION_UP "+"X: "+X+" Y: "+Y, Toast.LENGTH_SHORT).show();

	    break;

	}

	return true;

	}



}
