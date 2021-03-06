package com.example.lishan.timbo_min.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.IntegralBean;
import com.example.lishan.timbo_min.bean.SignInBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/25 0025.
 */

public class SignInAdapter extends RecyclerView.Adapter<IntegralAdapter.ViewHolder> {

//    public void setClickCallBack(ItemClickCallBack clickCallBack) {
//        this.clickCallBack = clickCallBack;
//    }
//
//    public interface ItemClickCallBack {
//        void onItemClick(int pos);
//    }

    public List<SignInBean> datas = null;
//    private ItemClickCallBack clickCallBack;

    public SignInAdapter(List<SignInBean> datas) {
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public IntegralAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_signin, viewGroup, false);
        return new IntegralAdapter.ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(IntegralAdapter.ViewHolder viewHolder, final int position) {
//        viewHolder.mTextView.setText(datas.get(position));
//        viewHolder.mTextView.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (clickCallBack != null) {
//                            clickCallBack.onItemClick(position);
//                        }
//                    }
//                }
//        );
    }

    @Override
    public void onBindViewHolder(IntegralAdapter.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
//            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }
}





















