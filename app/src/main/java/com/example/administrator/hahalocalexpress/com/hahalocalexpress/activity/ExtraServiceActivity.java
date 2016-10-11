package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.hahalocalexpress.R;

/**
 * 额外服务
 * Created by Administrator on 2016/10/11.
 */
public class ExtraServiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.extra_service);
    }
}
