package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.VoteBean;
import com.example.lishan.timbo_min.bean.VotingDetailsBean;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class VotingDetailsAdapter extends RecyclerView.Adapter<VotingDetailsAdapter.MyViewHolder> {
    private Context context;
    private List<VotingDetailsBean> datas;
    private BackButtonClick1 backButtonClick;

    public VotingDetailsAdapter(BackButtonClick1 backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<VotingDetailsBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_votingdetails, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonClick.backItem(position);
            }
        });
        holder.tv2.setOnClickListener(new View.OnClickListener() {
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
        private TextView tv1, tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.votingdetails_pinglun);
            tv2 = (TextView) itemView.findViewById(R.id.votingdetails_pinglun1);
        }
    }

    public interface BackButtonClick1 {
        void backItem(int indext);
    }
}

