package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.hahalocalexpress.R;

/**
 * 新增常用路线
 * Created by Administrator on 2016/10/7.
 */
public class AddCommonRouteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addcommonroute);
    }
}
