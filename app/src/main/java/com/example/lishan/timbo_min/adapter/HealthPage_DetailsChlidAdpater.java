package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ItemCommentsBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HealthPage_DetailsChlidAdpater extends RecyclerView.Adapter<HealthPage_DetailsChlidAdpater.ViewHolder> {
    private Context context;
    private int indext1;

    public void setClickCallBack(ItemClickCallBackChlid clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBackChlid {
        void onItemClick(int pos, int chlid);
    }

    public void setDatas(int indext, List<ItemCommentsBean.CommentDataBean.CommentBean.MoreBean> datas, Context context1) {
        this.datas = datas;
        this.context = context1;
        indext1 = indext;
    }

    public List<ItemCommentsBean.CommentDataBean.CommentBean.MoreBean> datas = null;
    private ItemClickCallBackChlid clickCallBack;


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_comantutils_chlid, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ItemCommentsBean.CommentDataBean.CommentBean.MoreBean itemCommentsBean = datas.get(position);
        Glide.with(context).load(itemCommentsBean.getHeadimg()).placeholder(R.mipmap.icon_hader).into(viewHolder.hader);
        viewHolder.name.setText(itemCommentsBean.getName());
        viewHolder.addr.setText(itemCommentsBean.getGrade());
        viewHolder.content.setText(itemCommentsBean.getContent());
        viewHolder.praise_num.setText(itemCommentsBean.getPraise_num());
        viewHolder.img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickCallBack != null) {
                            clickCallBack.onItemClick(indext1, position);
                        }
                    }
                }
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView hader;
        TextView name, addr, content, praise_num;
        ImageView img;

        public ViewHolder(View view) {
            super(view);
            hader = (CircleImageView) view.findViewById(R.id.view_comantutils_chlid_hader);
            name = (TextView) view.findViewById(R.id.view_comantutils_chlid_nickName);
            addr = (TextView) view.findViewById(R.id.view_comantutils_chlid_addr);
            content = (TextView) view.findViewById(R.id.view_comantutils_chlid_content);
            praise_num = (TextView) view.findViewById(R.id.view_comantutils_chlid_praise_num);
            img = (ImageView) view.findViewById(R.id.chlid_Message);
        }
    }
}