package com.lynas.fragsipetest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;



public class TabSwipeActivity extends SherlockFragmentActivity{
	
	public ViewPager btViewPager;
	protected TabsAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		btViewPager = new ViewPager(this);
		adapter = new TabsAdapter(this, btViewPager);
		btViewPager.setAdapter(adapter);
		btViewPager.setOnPageChangeListener(adapter);
		btViewPager.setId(R.layout.activity_main); //lynas changed here
		
		super.onCreate(savedInstanceState);
		setContentView(btViewPager);
	}
	
	protected void addTab(/*int tabView*/int iconRes, int titleRes, Class<?> fragmentClass, Bundle args){
		
		adapter.addTab(/*tabView*/iconRes, getString(titleRes), fragmentClass, args);
	}
	
	protected void addTab(/*int tabView,*/int icon, CharSequence title, Class<?> fragmentClass, Bundle args){
		adapter.addTab(icon, title, fragmentClass, args);
	}
	
	public static class TabsAdapter extends FragmentPagerAdapter implements TabListener, ViewPager.OnPageChangeListener{
		
		private final SherlockFragmentActivity btActivity;
		private final ActionBar btActionBar;
		private final ViewPager btPager;
		
		public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager){
			super(activity.getSupportFragmentManager());
			this.btActivity = activity;
			this.btActionBar = activity.getSupportActionBar();
			this.btPager = pager;
			
			btActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		}
		
		public static class TabInfo{
			public final Class<?> fragmentClass;
			public final Bundle args;
			public TabInfo(Class<?> fragmentClass, Bundle args){
				this.fragmentClass = fragmentClass;
				this.args = args;
			}
		}
		
		private List<TabInfo> btTabs = new ArrayList<TabInfo>();
		
		public void addTab(/*int tabView*/ int icon, CharSequence title, Class<?> fragmentClass, Bundle args ){
			final TabInfo tabInfo = new TabInfo(fragmentClass, args);
			
			Tab tab = btActionBar.newTab();
			
			tab.setIcon(icon);
			tab.setText("   " + title);
			//tab.setCustomView(tabView);
			tab.setTabListener(this);
			tab.setTag(tabInfo);

			btTabs.add(tabInfo);
			
			btActionBar.addTab(tab);
			notifyDataSetChanged();
		}
		
		@Override
		public Fragment getItem(int position){
			final TabInfo tabInfo = (TabInfo) btTabs.get(position);
			return Fragment.instantiate(btActivity,  tabInfo.fragmentClass.getName(), tabInfo.args);
		}
		
		@Override
		public int getCount(){
			return btTabs.size();
		}
		
		public void onPageScrollStateChanged(int arg0){
		}
		
		public void onPageScrolled(int arg0, float arg1, int arg2){
		}
		
		public void onPageSelected(int position){
			btActionBar.setSelectedNavigationItem(position);
		}
		
		public void onTabSelected(Tab tab, FragmentTransaction ft){
			TabInfo tabInfo = (TabInfo) tab.getTag();
			final int tabSize = btTabs.size();
			for(int i = 0; i < tabSize; i++){
				if(btTabs.get(i) == tabInfo){
					btPager.setCurrentItem(i);
				}
			}
		}
		
		public void onTabUnselected(Tab tab, FragmentTransaction ft){
		}
		
		public void onTabReselected(Tab tab, FragmentTransaction ft){
		}
	}

}
