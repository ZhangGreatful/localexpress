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
import com.example.administrator.hahalocalexpress.com.hahalocalexpress.bean.RegionType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页 车辆信息的Adapter
 * Created by Administrator on 2016/9/30.
 */
public class CarInfoAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private RegionType regionType;

    public CarInfoAdapter(Context context,RegionType regionType ) {
        this.mContext = context;
        this.regionType=regionType;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    ;

    @Override
    public int getCount() {
        return regionType.getObj().size();

    }

    @Override
    public Object getItem(int position) {
        return regionType.getObj().get(position);
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
        String url=regionType.getObj().get(position).getCarimg();
        Picasso.with(mContext).load(url).into(viewHolder.iv_car);
        viewHolder.tv_car.setText(regionType.getObj().get(position).getCarname());
        viewHolder.tv_car_price.setText(regionType.getObj().get(position).getStart_price());
        viewHolder.tv_car_weight.setText(regionType.getObj().get(position).getCapaticy());
        viewHolder.tv_car_size.setText(regionType.getObj().get(position).getLwh());
        viewHolder.tv_car_fee.setText(regionType.getObj().get(position).getOverkilometersfee());
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
