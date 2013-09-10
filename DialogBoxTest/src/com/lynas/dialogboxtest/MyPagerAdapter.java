package com.lynas.dialogboxtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by henry on 5/23/13.
 */
public class MyPagerAdapter extends PagerAdapter implements
		ViewPager.OnPageChangeListener {
	private Drawable myDrawable;

	private Context context;

	// private PagerTabStrip tabStrip;

	MyPagerAdapter(Context context) {
		super();

		this.context = context;

	}

	public int getCount() {
		return 5;
	}

	public Object instantiateItem(ViewGroup collection, int position) {

		LayoutInflater inflater = (LayoutInflater) collection.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		int resId = 0;
		switch (position) {
		case 0:
			resId = R.layout.swipe1;
			break;
		case 1:
			resId = R.layout.swipe2;
			break;
		case 2:
			resId = R.layout.swipe3;
			break;
		case 3:
			resId = R.layout.swipe4;
			break;
		case 4:
			resId = R.layout.swipe5;
			break;
		}
		
		
		View view = inflater.inflate(resId, null);
		((ViewPager) collection).addView(view);

		String[] FRUITS = new String[] { "Apple", "Avocado", "Banana" };

		ListView lv = (ListView) view.findViewById(R.id.listView1);

		ArrayAdapter<String> adp = new ArrayAdapter<String>(context,
				R.layout.eachlist, FRUITS);

		lv.setAdapter(adp);

		
		
		return view;
	}

	@Override
	public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView((View) arg2);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return arg0 == ((View) arg1);
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {

/*		
 		String[] FRUITS = new String[] { "Apple", "Avocado", "Banana" };

		ListView lv = (ListView) findViewById(R.id.listView1);

		ArrayAdapter<String> adp = new ArrayAdapter<String>(context,
				R.layout.eachlist, FRUITS);

		lv.setAdapter(adp);
		
		*/
		myDrawable = context.getResources().getDrawable(R.drawable.ic_launcher);

		SpannableStringBuilder sb = new SpannableStringBuilder(" "); // space added before text for convenience

		myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(),
				myDrawable.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);
		sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		return sb;
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

	}

}