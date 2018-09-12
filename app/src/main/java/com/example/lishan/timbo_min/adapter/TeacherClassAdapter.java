package com.example.lishan.timbo_min.adapter;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.TeacherClassBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.List;
/**
 * Created by jianghejie on 15/11/26.
 */
public class TeacherClassAdapter extends RecyclerView.Adapter<TeacherClassAdapter.ViewHolder> {
    private SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();
    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }
    public static final int BASE_ITEM_TYPE_FOOTER = 200000;
    public interface ItemClickCallBack{
        void OnBackItem(int indext);

        void OnModify(int indext);
        void OnButn(int indext);
    }

    public List<TeacherClassBean> datas = null;
    private ItemClickCallBack clickCallBack;

    public TeacherClassAdapter(List<TeacherClassBean> datas) {
        this.datas = datas;
    }
    public int getFootersCount(){
        return mFooterViews.size();
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teacherclass,viewGroup,false);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        viewHolder.mLinear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(clickCallBack != null){
                            clickCallBack.OnBackItem(position);
                        }
                    }
                }
        );
        viewHolder.mModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 clickCallBack.OnModify(position);
            }
        });
        viewHolder.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallBack.OnButn(position);
            }
        });
        if((datas.size()-1)==position){
            viewHolder.but.setVisibility(View.VISIBLE);
        }else {
            viewHolder.but.setVisibility(View.GONE);
        }
    }
    public void addFooterView(View view){
        mFooterViews.put(mFooterViews.size() + BASE_ITEM_TYPE_FOOTER,view);
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLinear;
        public TextView mModify,but;
        public ViewHolder(View view){
            super(view);
            mLinear = (LinearLayout) view.findViewById(R.id.item_teacherclass);
            mModify= (TextView) view.findViewById(R.id.teacherclass_modify);
            but= (TextView) view.findViewById(R.id.teacherclass_fabu);
        }
    }
}





















