package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.hahalocalexpress.R;

/**
 * Created by Administrator on 2016/10/10.
 */
public class ConfirmOrderActivity extends Activity implements View.OnClickListener {
    private ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_order);
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
