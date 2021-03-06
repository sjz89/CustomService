package com.bielang.customserver.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bielang.customserver.bean.MonitorData;
import com.bielang.customserver.R;

import java.util.ArrayList;

public class MonitorListAdapter extends BaseAdapter{
    private ArrayList<MonitorData> mData;
    private Context mContext;

    public MonitorListAdapter(Context context,ArrayList<MonitorData> data){
        this.mContext=context;
        this.mData=data;
    }
    public void Refresh(){
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_monitor,null);
            viewHolder=new MyViewHolder(view);
            view.setTag(viewHolder);
        }else
            viewHolder=(MyViewHolder)view.getTag();
        viewHolder.name.setText(String.valueOf("ID:"+mData.get(i).getId()));
        viewHolder.number.setText(String.valueOf("当前接待量："+mData.get(i).getNumber()));
        if (mData.get(i).isOnline())
            viewHolder.state.setText("在线");
        else
            viewHolder.state.setText("离线");
        return view;
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView number;
        TextView state;
        private MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.monitor_name);
            number=itemView.findViewById(R.id.monitor_number);
            state=itemView.findViewById(R.id.monitor_state);
        }
    }
}
