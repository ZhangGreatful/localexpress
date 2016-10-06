package com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;

/**
 * Created by Administrator on 2016/9/29.
 */
public class OrderFragment extends Fragment {
    private Context mContext;
    private FragmentTabHost orderTabHost;
    private LayoutInflater inflater;
    private String textArray[] = {"全部", "服务中", "待评价", "取消"};
    private Class fragmentArray[] = {AllOderFragment.class, ServicingFragment.class, EvaluateFragment.class, CanceledFragment.class};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.orderfragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mContext = getActivity();
        orderTabHost = (FragmentTabHost) this.getActivity().findViewById(R.id.order_tabhost);
        inflater = LayoutInflater.from(mContext);
        orderTabHost.setup(mContext, getFragmentManager());
        int count = fragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = orderTabHost.newTabSpec(textArray[i]).setIndicator(getTabItemView(i));
            orderTabHost.addTab(tabSpec, fragmentArray[i], null);
        }
        updateTab(orderTabHost);
        orderTabHost.setOnTabChangedListener(tabChangeListener);
    }

    private TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String s) {
            updateTab(orderTabHost);
        }
    };

    private void updateTab(FragmentTabHost mTabHost) {
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(R.id.tv_text);
            ImageView iv = (ImageView) mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(R.id.iv_bottom_line);
            if (mTabHost.getCurrentTab() == i) {//选中
                iv.setVisibility(View.VISIBLE);
            } else {//不选中
                iv.setVisibility(View.INVISIBLE);
            }
        }
    }

    //      为tab键设置图片和文字
    private View getTabItemView(int index) {
        View view = inflater.inflate(R.layout.order_tab_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.tv_text);
        imageView.setVisibility(View.VISIBLE);
        textView.setText(textArray[index]);
        return view;

    }
}

