package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.HomeListBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/12.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.MyViewHolder> {
    private List<HomeListBean> datas;
    private Context context;
    public void setDatas(List<HomeListBean> datas) {
        this.datas = datas;
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public HomeListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_homlist, parent,false));
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(HomeListAdapter.MyViewHolder holder, int position) {
        HomeListBean item = datas.get(position);
        switch (item.getState()){
            case "1":
                holder.home3.setVisibility(View.VISIBLE);
                holder.home1.setVisibility(View.VISIBLE);
                break;
            case "2":
                holder.home1.setVisibility(View.GONE);
                break;
            case "3":
                holder.home3.setVisibility(View.GONE);
                holder.home1.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout home1;
        private ImageView home3;
        public MyViewHolder(View view) {
            super(view);
            home1 = (LinearLayout) view.findViewById(R.id.item_home1);
            home3 = (ImageView) view.findViewById(R.id.item_HomeHader);
        }
    }
}
