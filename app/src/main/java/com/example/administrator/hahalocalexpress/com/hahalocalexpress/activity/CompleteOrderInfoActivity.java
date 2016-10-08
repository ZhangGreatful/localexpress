package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.CompleteOrderAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 完善订单信息
 * Created by Administrator on 2016/10/7.
 */
public class CompleteOrderInfoActivity extends Activity implements View.OnClickListener {
    private ImageView mBack;
    private TextView mCommonRoute;
    private ListView mListView;
    private CompleteOrderAdapter mAdapter;
    private RelativeLayout relativeLayout;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.complete_order_info);
        initView();
    }

    private void initView() {
        list.add("请输入始发地");
        list.add("请输入目的地");
        mBack = (ImageView) findViewById(R.id.iv_back);
        mCommonRoute = (TextView) findViewById(R.id.tv_common_route);
        mListView = (ListView) findViewById(R.id.lv_complete_order);
        mAdapter = new CompleteOrderAdapter(this,list);
        relativeLayout= (RelativeLayout) findViewById(R.id.add_destination);
        mListView.setAdapter(mAdapter);

        mBack.setOnClickListener(this);
        mCommonRoute.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                Intent intent = new Intent(CompleteOrderInfoActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_common_route:
                Intent intent1 = new Intent(CompleteOrderInfoActivity.this, SelectCommonRouteActivity.class);
                startActivity(intent1);
                break;
            case R.id.add_destination:
                list.add("请输入途径地");
                mAdapter.notifyDataSetChanged();
        }
    }
}
