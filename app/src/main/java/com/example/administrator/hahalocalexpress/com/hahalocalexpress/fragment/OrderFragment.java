package com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity.MainActivity;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
public class OrderFragment extends Fragment implements View.OnClickListener {

    private ImageView mBack;
    private ArrayList<Fragment> fragmentList;
    private Fragment allOrderFragment, canceledFragment, servicingFragment, evaluateFragment;
    private TextView tab1Text, tab2Text, tab3Text, tab4Text;
    private ViewPager mViewPager;
    private View tabLine;
    private ImageView callCar;
    private Animation animation;

    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    private int position_two;
    private int position_three;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.orderfragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAdapter();
        initView();
        InitWidth();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewPager.setCurrentItem(0);
    }

    private void initAdapter() {
        fragmentList = new ArrayList<>();
        allOrderFragment = new AllOderFragment();
        canceledFragment = new CanceledFragment();
        servicingFragment = new ServicingFragment();
        evaluateFragment = new EvaluateFragment();
        fragmentList.add(allOrderFragment);
        fragmentList.add(servicingFragment);
        fragmentList.add(evaluateFragment);
        fragmentList.add(canceledFragment);
    }

    private void initView() {
        mBack = (ImageView) this.getActivity().findViewById(R.id.iv_back);
        tab1Text = (TextView) this.getActivity().findViewById(R.id.tab1);
        tab2Text = (TextView) this.getActivity().findViewById(R.id.tab2);
        tab3Text = (TextView) this.getActivity().findViewById(R.id.tab3);
        tab4Text = (TextView) this.getActivity().findViewById(R.id.tab4);

        callCar = (ImageView) this.getActivity().findViewById(R.id.iv_call_car);

        mBack.setOnClickListener(this);
        tab1Text.setOnClickListener(new MyOnClickListener(0));
        tab2Text.setOnClickListener(new MyOnClickListener(1));
        tab3Text.setOnClickListener(new MyOnClickListener(2));
        tab4Text.setOnClickListener(new MyOnClickListener(3));
        callCar.setOnClickListener(this);

        //初始化ViewPager，并且设置ViewPager的监听器
        mViewPager = (ViewPager) this.getActivity().findViewById(R.id.pager);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList));//解决fragment嵌套问题

        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    private void InitWidth() {
        tabLine = this.getActivity().findViewById(R.id.tab_line);
        bottomLineWidth = tabLine.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (int) ((screenW / 4.0 - bottomLineWidth) / 2);

        position_one = (int) (screenW / 4.0);
        position_two = position_one * 2;
        position_three = position_one * 3;
    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(index);
        }
    }

    ;

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {

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
            animation.setDuration(100);
            tabLine.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_call_car:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_back:
                Intent intent1 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

