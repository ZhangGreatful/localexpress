package com.example.administrator.hahalocalexpress.com.hahalocalexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hahalocalexpress.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class CompleteOrderAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list =new ArrayList<>();
    private LayoutInflater mInflater;

    public CompleteOrderAdapter(Context context,List<String>list) {
        this.mContext = context;
        this.list=list;
//        list.add("请输入始发地");
//        list.add("请输入目的地");
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            view = mInflater.inflate(R.layout.complete_order_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv_start);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_target);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (position == 0) {
            viewHolder.imageView.setImageResource(R.drawable.start);
            viewHolder.textView.setHint("请输入起始地");
        } else if (position == list.size() - 1) {
            viewHolder.imageView.setImageResource(R.drawable.end);
            viewHolder.textView.setHint("请输入目的地");
        }else {
            viewHolder.imageView.setImageResource(R.drawable.end);
            viewHolder.textView.setHint("请输入途径地");
        }
        notifyDataSetChanged();
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
