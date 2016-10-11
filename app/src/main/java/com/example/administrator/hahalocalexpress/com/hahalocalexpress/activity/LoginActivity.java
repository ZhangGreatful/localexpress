package com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.administrator.hahalocalexpress.R;

/**
 * Created by Administrator on 2016/10/11.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private ImageView iv_next;
    private EditText query;
    private ImageButton search_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log_in);
        initView();

    }

    private void initView() {
        query= (EditText) findViewById(R.id.query);
        search_clear= (ImageButton) findViewById(R.id.search_clear);
        iv_next= (ImageView) findViewById(R.id.iv_next);



        search_clear.setOnClickListener(this);

        query.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    search_clear.setVisibility(View.VISIBLE);
                } else {
                    search_clear.setVisibility(View.INVISIBLE);

                }
                if(s.length()<11){
                    iv_next.setImageResource(R.drawable.next_button_clicked);
                }else {
                    iv_next.setImageResource(R.drawable.next_button);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                iv_next.setImageResource(R.drawable.next_button_clicked);
            }

            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_clear:
                query.getText().clear();
                break;
        }
    }
}
