package com.lynas.swipewithviewpager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;


public class SwipeHandler extends SherlockFragmentActivity{
	
	private ViewPager myViewPager;
	private TabsAdapter myTabsAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		myViewPager = new ViewPager(this);
		myViewPager.setId(R.id.tabhost);
		setContentView(myViewPager);
		
		
		myTabsAdapter = new TabsAdapter(this, myViewPager);
		 
		
		
		//mTabsAdapter.addTab(bar.newTab().setText("Fragment 1"), Fragment_1.class, null);
		
		
		
		
		
		
		
	}

}
