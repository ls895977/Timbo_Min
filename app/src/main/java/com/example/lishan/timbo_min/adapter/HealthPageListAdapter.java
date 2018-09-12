package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class HealthPageListAdapter extends RecyclerView.Adapter<HealthPageListAdapter.ViewHolder> {
    private Context context;
    private List<HealthPagerListBean> datas;
    private OnItem onItem1;
   public HealthPageListAdapter(OnItem onItem){
       this.onItem1=onItem;
   };
    public void setDatas(List<HealthPagerListBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_healthpagerlist, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HealthPagerListBean item = datas.get(position);
        switch (item.getName()) {
            case "1":
                holder.myImage.setVisibility(View.VISIBLE);
                break;
            case "2":
                holder.myImage.setVisibility(View.GONE);
                break;
        }
        holder.myLinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItem1.clickView(view, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myImage;
        private LinearLayout myLinearlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            myImage = (ImageView) itemView.findViewById(R.id.item_healthpagerlistimage);
            myLinearlayout = (LinearLayout) itemView.findViewById(R.id.mhealthageritem);
        }
    }

   public interface OnItem {
        void clickView(View view, int position);
    }
}

