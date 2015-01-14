package com.hitwicket.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hitwicket.tabs.common.view.SlidingTabLayout;


public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";

	private SlidingTabLayout mSlidingTabLayout;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(new SamplePagerAdapter());
		mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setViewPager(mViewPager);
	}

	class SamplePagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public boolean isViewFromObject(View view, Object o) {
			return o == view;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Item " + (position + 1);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = getLayoutInflater().inflate(R.layout.pager_item, container, false);
			container.addView(view);
			((TextView) view.findViewById(R.id.item_title)).setText(String.valueOf(position + 1));
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}

}