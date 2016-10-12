package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.MyFragmentPagerAdapter;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.TabPageIndicatorAdapter;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.ServiceBaseFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.ServiceCouponFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.ServiceOrderFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.ServicePayFragment;

import java.util.ArrayList;
import java.util.List;

import shanyao.tabpagerindictor.TabPageIndicator;

/**
 * 客服中心
 * Created by Administrator on 2016/10/11.
 */
public class ServiceCenterActivity extends FragmentActivity  {

    private ViewPager viewPager;
    private LinearLayout basePro, orderPro, payPro, couponPro;
    private ImageView ivBottomLine;
    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    private int position_two;
    private int position_three;
    private ArrayList<Fragment> list = new ArrayList<>();
    private Fragment baseFragment, orderFragment, payFragment, couponFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.service_center);
        initView();
        initWidth();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        basePro = (LinearLayout) findViewById(R.id.ll_base);
        payPro = (LinearLayout) findViewById(R.id.ll_pay);
        couponPro = (LinearLayout) findViewById(R.id.ll_coupon);
        orderPro = (LinearLayout) findViewById(R.id.ll_order);
        baseFragment = new ServiceBaseFragment();
        orderFragment = new ServiceOrderFragment();
        couponFragment = new ServiceCouponFragment();
        payFragment = new ServicePayFragment();
        list.add(baseFragment);
        list.add(orderFragment);
        list.add(couponFragment);
        list.add(payFragment);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), list));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        basePro.setOnClickListener(new MyOnClickListener(0));
        orderPro.setOnClickListener(new MyOnClickListener(1));
        payPro.setOnClickListener(new MyOnClickListener(2));
        couponPro.setOnClickListener(new MyOnClickListener(3));

    }

    /**
     * 初始化图片下划线的宽度
     */
    private void initWidth() {
        ivBottomLine = (ImageView) findViewById(R.id.iv_bottom_line);
        bottomLineWidth = ivBottomLine.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (int) ((screenW / 4.0 - bottomLineWidth) / 2);
        position_one = (int) (screenW / 4.0);
        position_two = position_one * 2;
        position_three = position_one * 3;
    }

    /**
     * viewPager的点击事件
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, 0, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, 0, 0, 0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_one, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, position_one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_two, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, position_two, 0, 0);
                    }
                    break;
                case 3:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_three, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_three, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_three, 0, 0);
                    }
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(300);
            ivBottomLine.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    /**
     * 4个图片的点击事件
     */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }
    }

    ;
}
