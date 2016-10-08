package com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.hahalocalexpress.R;

/**
 * Created by Administrator on 2016/10/6.
 */
public class ServicingFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.servicing_fragment, container, false);
    }
}
