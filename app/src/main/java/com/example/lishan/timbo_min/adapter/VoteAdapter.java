package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.MyClassBean;
import com.example.lishan.timbo_min.bean.VoteBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.MyViewHolder> {
    private Context context;
    private List<VoteBean> datas;
    private BackButtonClick1 backButtonClick;

    public VoteAdapter(BackButtonClick1 backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<VoteBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_vote, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mylinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.backItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mylinear;

        public MyViewHolder(View itemView) {
            super(itemView);
            mylinear = (LinearLayout) itemView.findViewById(R.id.item_votelinear);
        }
    }

    public interface BackButtonClick1 {
        void backItem(int indext);
    }
}

