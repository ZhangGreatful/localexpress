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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
public class OrderFragment extends Fragment implements View.OnClickListener {

    private ImageView mBack;
    private Context mContext;
    private List<Fragment> fragmentList;
    private Fragment allOrderFragment, canceledFragment, servicingFragment, evaluateFragment;
    private FragmentPagerAdapter mPagerAdapter;
    private TextView tab1Text, tab2Text, tab3Text, tab4Text;
    private ViewPager mViewPager;
    private View tabLine;
    private TabOnClickListener onClickListener;
    private ImageView callCar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.orderfragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mContext = getActivity();
        initAdapter();
        initView();
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
        mPagerAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
    }

    private void initView() {
        mBack= (ImageView) this.getActivity().findViewById(R.id.iv_back);
        tab1Text = (TextView) this.getActivity().findViewById(R.id.tab1);
        tab2Text = (TextView) this.getActivity().findViewById(R.id.tab2);
        tab3Text = (TextView) this.getActivity().findViewById(R.id.tab3);
        tab4Text = (TextView) this.getActivity().findViewById(R.id.tab4);
        tabLine = this.getActivity().findViewById(R.id.tab_line);
        callCar = (ImageView) this.getActivity().findViewById(R.id.iv_call_car);

        mBack.setOnClickListener(this);
        onClickListener = new TabOnClickListener();
        tab1Text.setOnClickListener(onClickListener);
        tab2Text.setOnClickListener(onClickListener);
        tab3Text.setOnClickListener(onClickListener);
        tab4Text.setOnClickListener(onClickListener);
        callCar.setOnClickListener(this);

        //初始化ViewPager，并且设置ViewPager的监听器
        mViewPager = (ViewPager) this.getActivity().findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //因为这里只有三个Tab,所有横条的宽带应该是屏幕的1/3
                int lineWidth = getLineWidth(4);

                //横条随着ViewPager一起滑动
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tabLine.getLayoutParams();
                params.leftMargin = (int) ((positionOffset + position) * lineWidth);
                tabLine.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 根据标题的个数获取横条应该设置的宽度
     *
     * @param tabCount
     * @return
     */
    public int getLineWidth(int tabCount) {
        DisplayMetrics metric = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        int lineWidth = metric.widthPixels / tabCount;
        return lineWidth;
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


    private class TabOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tab1:
                    //设置当前的页面
                    mViewPager.setCurrentItem(0);
                    break;

                case R.id.tab2:
                    //设置当前的页面
                    mViewPager.setCurrentItem(1);
                    break;

                case R.id.tab3:
                    //设置当前的页面
                    mViewPager.setCurrentItem(2);
                    break;
                case R.id.tab4:
                    //设置当前的页面
                    mViewPager.setCurrentItem(3);
                    break;
                default:
                    break;
            }
        }
    }
}

