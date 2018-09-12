package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.example.lishan.timbo_min.bean.HomeCouponBean;

import java.util.List;

/**
 * Created by lishan on 2018/5/27.
 */

public class HomeCouponAdapter extends RecyclerView.Adapter<HomeCouponAdapter.ViewHolder> {
    public List<HomeCouponBean> datas = null;

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Context mContext;

    public HomeCouponAdapter(List<HomeCouponBean> datas) {
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public HomeCouponAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_homecoupon, viewGroup, false);
        return new HomeCouponAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(HomeCouponAdapter.ViewHolder viewHolder, final int position) {

    }

    @Override
    public void onBindViewHolder(HomeCouponAdapter.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        HomeCouponBean item = datas.get(position);
        Resources resources = mContext.getResources();
        Drawable btnDrawable = null;
        switch (item.getImages()) {
            case 0:
                holder.mlinear1.setVisibility(View.VISIBLE);
                holder.mlinear2.setVisibility(View.GONE);
                holder.mlinear3.setVisibility(View.GONE);
                btnDrawable = resources.getDrawable(R.drawable.boder_homecoupon3);
                holder.title.setTextColor(getmContext().getResources().getColor(R.color.colco3));
                break;
            case 1:
                holder.mlinear1.setVisibility(View.GONE);
                holder.mlinear2.setVisibility(View.VISIBLE);
                holder.mlinear3.setVisibility(View.GONE);
                btnDrawable = resources.getDrawable(R.drawable.boder_homecoupon2);
                holder.title.setTextColor(getmContext().getResources().getColor(R.color.colco2));
                break;
            case 2:
                holder.mlinear1.setVisibility(View.GONE);
                holder.mlinear2.setVisibility(View.GONE);
                holder.mlinear3.setVisibility(View.VISIBLE);
                btnDrawable = resources.getDrawable(R.drawable.boder_homecoupon1);
                holder.title.setTextColor(getmContext().getResources().getColor(R.color.colco1));
                break;
        }
        holder.mlinear4.setBackgroundDrawable(btnDrawable);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        private LinearLayout mlinear1, mlinear2, mlinear4;
        private RelativeLayout mlinear3;

        public ViewHolder(View view) {
            super(view);
            mlinear1 = (LinearLayout) view.findViewById(R.id.item_homelinear1);
            mlinear2 = (LinearLayout) view.findViewById(R.id.item_homelinear2);
            mlinear3 = (RelativeLayout) view.findViewById(R.id.item_homelinear3);
            mlinear4 = (LinearLayout) view.findViewById(R.id.item_homelinear4);
            title = (TextView) view.findViewById(R.id.homecoupon_title);
        }
    }
}

