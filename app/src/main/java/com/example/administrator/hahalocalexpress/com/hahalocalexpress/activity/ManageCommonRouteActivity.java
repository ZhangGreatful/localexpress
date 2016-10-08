package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.hahalocalexpress.R;

/**
 * Created by Administrator on 2016/10/7.
 */
public class ManageCommonRouteActivity extends Activity implements View.OnClickListener {

    private ImageView mBack;
    private LinearLayout addRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.manage_common_route);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.iv_back);
        addRoute = (LinearLayout) findViewById(R.id.add_route);


        mBack.setOnClickListener(this);
        addRoute.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                Intent intent = new Intent(ManageCommonRouteActivity.this, SelectCommonRouteActivity.class);
                startActivity(intent);
                break;
            case R.id.add_route:
                Intent intent1 = new Intent(ManageCommonRouteActivity.this, AddCommonRouteActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
