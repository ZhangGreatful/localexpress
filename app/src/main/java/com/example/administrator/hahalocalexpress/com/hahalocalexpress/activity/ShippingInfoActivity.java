package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.hahalocalexpress.R;

/**
 * 发货信息
 * Created by Administrator on 2016/10/10.
 */
public class ShippingInfoActivity extends Activity implements View.OnClickListener {

    private ImageView mBack;
    private EditText edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shipping_info);
        initView();
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.iv_back);
        edtAddress = (EditText) findViewById(R.id.et_city);

        edtAddress.addTextChangedListener(new EditChangeListener());
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

    //      对输入框设置监听
    private class EditChangeListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
