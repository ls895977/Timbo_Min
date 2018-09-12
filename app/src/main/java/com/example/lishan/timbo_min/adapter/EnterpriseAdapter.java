package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.EnterpriseBean;
import com.example.lishan.timbo_min.bean.ExcellentStudentsBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/24.
 */

public class EnterpriseAdapter extends RecyclerView.Adapter<EnterpriseAdapter.MyViewHolder> {
    private Context context;
    private List<EnterpriseBean> datas;
    private EnterpriseAdapter.BackButtonClick1 backButtonClick;

    public EnterpriseAdapter(EnterpriseAdapter.BackButtonClick1 backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<EnterpriseBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EnterpriseAdapter.MyViewHolder viewHolder = new EnterpriseAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_enterprise, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        EnterpriseBean item=datas.get(position);
        holder.img.setImageResource(item.getImgs());
        holder.name.setText(item.getName());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonClick.backClcik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView img;
        private RelativeLayout item;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_enterprise_name);
            img= (ImageView) itemView.findViewById(R.id.item_enterprise_img);
            item= (RelativeLayout) itemView.findViewById(R.id.item_enterprise_item);
        }
    }

    public interface BackButtonClick1 {
        void backClcik(int indext);
    }
}