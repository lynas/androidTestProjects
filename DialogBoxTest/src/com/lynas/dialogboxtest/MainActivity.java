package com.lynas.dialogboxtest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button alb;
	final Context context = this;
	final private int RESET_DIALOG = 0;

	PagerAdapter hello;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// View myview ;
		// myview.se

		// hello.instantiateItem(container, position)

		showAlert();
	}

	public void showAlert() {
		alb = (Button) findViewById(R.id.button1);
		alb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(RESET_DIALOG);

			}
		});
	}

	@Override
	protected android.app.Dialog onCreateDialog(int id) {
		
		Dialog dialog;
		switch (id) {
		case RESET_DIALOG:
			dialog = new Dialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.customdialoguelayout);
			
			
			
			MyPagerAdapter adapter = new MyPagerAdapter();
			ViewPager myPager = (ViewPager) dialog.findViewById(R.id.myPager);
			// if (myPager == null)
			// Log.d("tag", "mypager null");
			// else
			// if (adapter.)
			// Log.d("tag", "adapter null");
			
			
			myPager.setAdapter(adapter);
			myPager.setCurrentItem(0);
			
			return dialog;
		}

		return null;
	};
	
	



}
