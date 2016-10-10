package com.example.administrator.hahalocalexpress.com.hahalocalexpress.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity.SelectCityActivity;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter.CarInfoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    private ListView mListView;
    private CarInfoAdapter carInfoAdapter;
    private LinearLayout selectCity;
    private int[] car_pic = {R.drawable.mianbao, R.drawable.jinbei, R.drawable.xianghuo, R.drawable.pingban, R.drawable.xiaopingban};
    private String[] car_name = {"小型面包", "金杯", "箱货", "大型平板", "小型平板"};
    private String[] price = {"33", "58", "120", "90", "48"};
    private String[] weight = {"1吨", "1.5吨", "1.8吨", "1.75吨", "1.5吨"};
    private String[] size = {"1.7*1.1*1米", "2.7*1.4*1.2米", "4.2*2.0*1.8米", "4.2*2.0*1.8米", "2.0*1.6*1.5米"};
    private String[] fee = {"3.0元/公里", "4.0元/公里", "5.0元/公里", "5.0元/公里", "4.5元/公里"};
    private List<String> list_car_name = new ArrayList<>();
    private List<Integer> list_car_pic = new ArrayList<>();
    private List<String> list_car_prince = new ArrayList<>();
    private List<String> list_car_weight = new ArrayList<>();
    private List<String> list_car_size = new ArrayList<>();
    private List<String> list_car_fee = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (String car : car_name) {
            list_car_name.add(car);
        }
        for (Integer in : car_pic) {
            list_car_pic.add(in);
        }
        for (String pri : price) {
            list_car_prince.add(pri);
        }
        for (String wei : weight) {
            list_car_weight.add(wei);
        }
        for (String siz : size) {
            list_car_size.add(siz);
        }
        for (String f : fee) {
            list_car_fee.add(f);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mContext=getActivity();
        selectCity= (LinearLayout) this.getActivity().findViewById(R.id.city);
        mListView = (ListView) this.getActivity().findViewById(R.id.lv_car);
        mListView.setDivider(null);
        carInfoAdapter = new CarInfoAdapter(mContext, list_car_pic, list_car_name, list_car_prince,
                list_car_weight, list_car_size, list_car_fee);
        mListView.setAdapter(carInfoAdapter);

        selectCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.city:
                Intent intent=new Intent(mContext,SelectCityActivity.class);
                startActivity(intent);
                break;
        }
    }
}
