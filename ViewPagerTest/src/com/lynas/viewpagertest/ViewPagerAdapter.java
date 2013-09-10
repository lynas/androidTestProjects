package com.lynas.viewpagertest;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View vw, Object obj) {
		// TODO Auto-generated method stub
		return vw == ((View) obj);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		LayoutInflater inflater = (LayoutInflater) container.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View page = inflater.inflate(R.layout.view_page_1, null);

		TextView tv = (TextView) page.findViewById(R.id.textView1);

		tv.setText("no" + position);

		((ViewPager) container).addView(page);

		return page;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView((View) object);
	}

}
