package com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
public class TabPageIndicatorAdapter extends PagerAdapter {
    private String[] TITLE ;
    private List<Fragment> fragment;

    public TabPageIndicatorAdapter(String[] TITLE , List<Fragment> fragment) {
        this.TITLE = TITLE;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }

    /**
     * 传递fragment
     *
     * @param container
     * @param position
     * @return
     */
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        return fragment.get(position);
//    }

}
