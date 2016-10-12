package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.hahalocalexpress.R;

/**
 * 收货信息
 * Created by Administrator on 2016/10/12.
 */
public class TakeOverActivity extends Activity implements View.OnClickListener {

    private ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_over);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.iv_back);


        mBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
