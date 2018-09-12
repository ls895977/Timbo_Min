package com.example.lishan.timbo_min.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;
import com.example.lishan.timbo_min.bean.CompetencEdducationBean;

import java.util.List;

/**
 * Created by lishan on 2018/1/19.
 */
public class CompetencEdducationAdapter extends RecyclerView.Adapter<CompetencEdducationAdapter.MyViewHolder> {
    private Context context;
    private List<CompetencEdducationBean.DataBean> datas;
    private  BackButtonClicked backButtonClick;

    public CompetencEdducationAdapter(BackButtonClicked backButtonClick1) {
        this.backButtonClick = backButtonClick1;
    }

    public void setDatas(List<CompetencEdducationBean.DataBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CompetencEdducationAdapter.MyViewHolder viewHolder = new CompetencEdducationAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_competencedducation, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

     holder.myLiner.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             backButtonClick.OnItemBack(position);
         }
     });
        CompetencEdducationBean.DataBean item=datas.get(position);
        Glide.with(context).load(item.getPortrait()).into(holder.imc);
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
      LinearLayout myLiner;
      private ImageView imc;
      private TextView company_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            myLiner= (LinearLayout) itemView.findViewById(R.id.mycompetenlinear);
            imc= (ImageView) itemView.findViewById(R.id.competenceducation_imc);
            company_name= (TextView) itemView.findViewById(R.id.competenceducation_name);
        }
    }

    public interface BackButtonClicked{
        void OnItemBack(int potion);

    }
}

