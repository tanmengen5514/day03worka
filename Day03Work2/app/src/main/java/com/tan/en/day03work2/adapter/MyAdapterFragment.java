package com.tan.en.day03work2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/22.
 */

public class MyAdapterFragment extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> items;

    public MyAdapterFragment(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> items) {
        super(fm);
        this.fragments = fragments;
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position);
    }
}
