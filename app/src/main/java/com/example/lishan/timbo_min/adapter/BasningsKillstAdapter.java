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
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.BasningskillstBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class BasningsKillstAdapter extends RecyclerView.Adapter<BasningsKillstAdapter.MyViewHolder> {
    private Context context;
    private List<BasningskillstBean> datas;
    private BackButtonItemClick backButtonClick;

    public BasningsKillstAdapter(BackButtonItemClick backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<BasningskillstBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_basningskillst, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.myClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.backClcikItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout myClick;

        public MyViewHolder(View itemView) {
            super(itemView);
            myClick= (LinearLayout) itemView.findViewById(R.id.basningsKillsItem);
        }
    }

    public interface BackButtonItemClick {
         void backClcikItem(int indext);
    }
}

