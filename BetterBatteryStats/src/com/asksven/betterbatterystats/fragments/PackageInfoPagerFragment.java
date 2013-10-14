/*
 * Copyright (C) 2013 asksven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asksven.betterbatterystats.fragments;

/**
 * @author sven
 *
 */
import com.actionbarsherlock.app.SherlockFragment;
import com.asksven.betterbatterystats.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PackageInfoPagerFragment extends SherlockFragment
{

	public static final String TAG = PackageInfoPagerFragment.class.getSimpleName();

	public static PackageInfoPagerFragment newInstance()
	{
		return new PackageInfoPagerFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_overview_pager, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
		mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
	}

	public class MyPagerAdapter extends FragmentPagerAdapter
	{

		private final String[] TITLES =
		{ "Package", "Permissions", "Services" };

		public MyPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			return TITLES[position];
		}

		@Override
		public int getCount()
		{
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position)
		{
			switch (position)
			{
			case 0:
				return PackagesFragment.newInstance(null);
			case 1:
				return PermissionsFragment.newInstance(null);
			case 2:
				return ServicesFragment.newInstance(null);
			default:
				return null;
			}
		}

	}


}