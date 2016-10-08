package com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.activity.CompleteOrderInfoActivity;

import java.util.List;

/**
 * 首页 车辆信息的Adapter
 * Created by Administrator on 2016/9/30.
 */
public class CarInfoAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    List<String> list_car_name;
    List<Integer> list_car_pic;
    List<String> list_car_prince;
    List<String> list_car_weight;
    List<String> list_car_size;
    List<String> list_car_fee;


    public CarInfoAdapter(Context context, List<Integer> car_pic, List<String> car_name, List<String> car_price,
                          List<String> car_weight, List<String> car_size, List<String> car_fee) {
        this.list_car_name = car_name;
        this.list_car_pic = car_pic;
        this.list_car_fee = car_fee;
        this.list_car_size = car_size;
        this.list_car_prince = car_price;
        this.list_car_weight = car_weight;
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    ;

    @Override
    public int getCount() {
        return list_car_name.size();

    }

    @Override
    public Object getItem(int position) {
        return list_car_name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            view = mInflater.inflate(R.layout.car_type_item, null);
            viewHolder = new ViewHolder();

            viewHolder.iv_car = (ImageView) view.findViewById(R.id.car_image);
            viewHolder.tv_car = (TextView) view.findViewById(R.id.car_type);
            viewHolder.tv_car_price = (TextView) view.findViewById(R.id.car_price);
            viewHolder.tv_car_weight = (TextView) view.findViewById(R.id.tv_car_weight);
            viewHolder.tv_car_size = (TextView) view.findViewById(R.id.tv_car_size);
            viewHolder.tv_car_fee = (TextView) view.findViewById(R.id.tv_car_fee);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mContext, CompleteOrderInfoActivity.class);
                mContext.startActivity(intent);
            }
        });
        Integer integer = list_car_pic.get(position);
        String car_name = list_car_name.get(position);
        String car_price = list_car_prince.get(position);
        String car_weight = list_car_weight.get(position);
        String car_size = list_car_size.get(position);
        String car_fee = list_car_fee.get(position);
        viewHolder.iv_car.setImageResource(integer);
        viewHolder.tv_car.setText(car_name);
        viewHolder.tv_car_price.setText(car_price);
        viewHolder.tv_car_weight.setText(car_weight);
        viewHolder.tv_car_size.setText(car_size);
        viewHolder.tv_car_fee.setText(car_fee);
        return view;
    }

    static class ViewHolder {
        ImageView iv_car;
        TextView tv_car;
        TextView tv_car_weight;
        TextView tv_car_price;
        TextView tv_car_size;
        TextView tv_car_fee;

    }
}
