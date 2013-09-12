package com.lynas.dialogboxtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	private Button alb;
	final Context context = this;
	final private int RESET_DIALOG = 0;

	PagerAdapter hello;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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

	@SuppressLint("NewApi")
	@Override
	protected android.app.Dialog onCreateDialog(int id) {

		Dialog dialog;
		switch (id) {
		case RESET_DIALOG:

			dialog = new Dialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.customdialoguelayout);

			String[] FRUITS = new String[] { "Apple", "Avocado", "Banana" };

			ScrollView lv = (ScrollView) dialog.findViewById(R.id.listView1);

			ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
					R.layout.eachlist, FRUITS);
			// lv.setAdapter(adp);

			MyPagerAdapter adapter = new MyPagerAdapter(this);
			final ViewPager myPager = (ViewPager) dialog.findViewById(R.id.myPager);

			myPager.setAdapter(adapter);
			myPager.setCurrentItem(2);

			ImageView im1 = new ImageView(this);
			im1.setBackgroundResource(R.drawable.ic_launcher);
			im1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					myPager.setCurrentItem(0);

				}
			});
			ImageView im2 = new ImageView(this);
			im2.setBackgroundResource(R.drawable.ic_launcher);
			im2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					myPager.setCurrentItem(1);

				}
			});

			LinearLayout myLl = new LinearLayout(this);
			myLl.addView(im1);
			myLl.addView(im2);

			lv.addView(myLl);

			return dialog;
		}

		return null;
	};

}
