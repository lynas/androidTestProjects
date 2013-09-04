package com.lynas.swipewithviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.rufflez.swipeytabs.TabsAdapter.TabInfo;

public class TabsAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener{
	private final Context mContext;
	//private final ActionBar mActionBar;
	private final ViewPager mViewPager;
	
	
	public TabsAdapter(SherlockFragmentActivity fa, ViewPager pager) {
		super(fa.getSupportFragmentManager());
		
		mViewPager = pager;
		mContext = fa;
	}

	
	/*
	public TabsAdapter(SherlockFragmentActivity fa, ViewPager pager) {
		super(fa.getSupportFragmentManager());
		mContext = fa;
		mActionBar = fa.getSupportActionBar();
		mViewPager = pager;
		mViewPager.setAdapter(this);
		mViewPager.setOnPageChangeListener(this);
	}
	*/
	
	public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
		
		
		//tab.setTabListener(this);
		
		//mActionBar.addTab(tab);
		//notifyDataSetChanged();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
