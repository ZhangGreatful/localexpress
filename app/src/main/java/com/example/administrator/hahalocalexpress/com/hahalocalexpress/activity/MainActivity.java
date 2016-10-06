package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.FavorableFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.HomeFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.MineFragment;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment.OrderFragment;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater inflater;
    private Class mFragmentArray[] = {HomeFragment.class, FavorableFragment.class, OrderFragment.class,
            MineFragment.class};
    private int mImageArray[] = {R.drawable.tab_home, R.drawable.tab_order,
            R.drawable.tab_favorable, R.drawable.tab_mine,};
    private String textArray[] = {"首页", "订单管理", "优惠活动", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }
    /**
     * 初始化组件
     */
    private void initView() {
        inflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.content);

        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabSpec tabSpec = mTabHost.newTabSpec(textArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
        }
        updateTab(mTabHost);
        mTabHost.setOnTabChangedListener(tabChangeListener);
    }

    private TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String s) {
            updateTab(mTabHost);
        }
    };

    //          更新tab键文字
    private void updateTab(FragmentTabHost mTabHost) {
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(R.id.textview);
            if (mTabHost.getCurrentTab() == i) {//选中
                tv.setTextColor(this.getResources().getColorStateList(
                        R.color.orange));
            } else {//不选中
                tv.setTextColor(this.getResources().getColorStateList(
                        android.R.color.darker_gray));
            }
        }
    }

    //      为tab键设置图片和文字
    private View getTabItemView(int index) {
        View view = inflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mImageArray[index]);
        textView.setText(textArray[index]);
        return view;

    }
}
