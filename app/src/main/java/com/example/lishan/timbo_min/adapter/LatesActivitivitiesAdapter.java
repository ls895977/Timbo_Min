package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.LatesActivitivitiesBean;
import com.example.lishan.timbo_min.common.MyTooL;
import com.lykj.aextreme.afinal.view.CircleImageView;

import java.util.List;

/**
 * Created by lishan on 2017/12/18.
 */

public class LatesActivitivitiesAdapter extends RecyclerView.Adapter<LatesActivitivitiesAdapter.MyViewHolder> {
    private Context context;
    private List<LatesActivitivitiesBean.ActDataBean> datas;
    private OnBackButtonItemClick backButtonClick;

    public LatesActivitivitiesAdapter(OnBackButtonItemClick backButtonClick1,List<LatesActivitivitiesBean.ActDataBean> datas) {
        this.datas = datas;
        this.backButtonClick = backButtonClick1;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_latesactivitivities, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (datas.get(position).getAct_address() == null) {
            holder.itemRelative.setVisibility(View.VISIBLE);
            holder.item.setVisibility(View.GONE);
        } else {
            holder.itemRelative.setVisibility(View.GONE);
            holder.item.setVisibility(View.VISIBLE);
            LatesActivitivitiesBean.ActDataBean item = datas.get(position);
            Glide.with(context)
                    .load(item.getCom_headimg())
                    .into(holder.itemImage);
            holder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backButtonClick.backItemClcik(position);
                }
            });
            holder.title.setText(item.getTitle());
            holder.comName.setText(item.getCom_name());
            holder.addr.setText(item.getAct_address());
            holder.ctime.setText(item.getCtime());
            holder.act_start.setText(MyTooL.getStandardDate(item.getAct_start()));
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout item;//显示有数据
        private RelativeLayout itemRelative;//显示未有数据
        private TextView title, comName, addr, ctime, act_start;
        private de.hdodenhof.circleimageview.CircleImageView itemImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            item = (LinearLayout) itemView.findViewById(R.id.item_latesactivity);
            itemRelative = (RelativeLayout) itemView.findViewById(R.id.Relative_noDaata);
            itemImage = (de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.item_latesactivityties_profile_image);
            title = (TextView) itemView.findViewById(R.id.item_latesactivityties_title);
            comName = (TextView) itemView.findViewById(R.id.item_latesactivityties_com_name);
            addr = (TextView) itemView.findViewById(R.id.item_latesactivityties_act_address);
            ctime = (TextView) itemView.findViewById(R.id.item_latesactivityties_ctime);
            act_start = (TextView) itemView.findViewById(R.id.item_latesactivityties_act_start);
        }
    }

    public interface OnBackButtonItemClick {
        void backItemClcik(int indext);
    }
}

