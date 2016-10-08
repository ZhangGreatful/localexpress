package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;

/**
 * 选择常用路线
 * Created by Administrator on 2016/10/7.
 */
public class SelectCommonRouteActivity extends Activity implements View.OnClickListener {

    private ImageView mBack;
    private TextView mManager;
    private LinearLayout addRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.select_common_route);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.iv_back);
        mManager = (TextView) findViewById(R.id.tv_manage);
        addRoute = (LinearLayout) findViewById(R.id.add_route);


        mBack.setOnClickListener(this);
        mManager.setOnClickListener(this);
        addRoute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                Intent intent = new Intent(SelectCommonRouteActivity.this, CompleteOrderInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_manage:
                Intent intent1 = new Intent(SelectCommonRouteActivity.this, ManageCommonRouteActivity.class);
                startActivity(intent1);
                break;
            case R.id.add_route:
                Intent intent2 = new Intent(SelectCommonRouteActivity.this, AddCommonRouteActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
