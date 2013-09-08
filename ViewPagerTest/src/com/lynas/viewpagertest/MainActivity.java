package com.lynas.viewpagertest;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ViewPager mypager = (ViewPager) findViewById(R.id.pager);
		
		ViewPagerAdapter myadapter = new ViewPagerAdapter();
		mypager.setAdapter(myadapter);
	}


}
