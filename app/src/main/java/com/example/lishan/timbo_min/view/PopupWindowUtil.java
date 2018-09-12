package com.example.lishan.timbo_min.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.ArenaTitleBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2018/1/14.
 */

public class PopupWindowUtil {
    private GridView mygridview;
    private PopupWindow window;
    private OnBackItemPosition onBackItemPosition;
    //窗口在x轴偏移量
    private int xOff = 0;
    //窗口在y轴的偏移量
    private int yOff = 0;

    public PopupWindowUtil(Context context, List<ArenaTitleBean.DataBean> datas, OnBackItemPosition onBackItemPosition1) {
        onBackItemPosition = onBackItemPosition1;
        window = new PopupWindow(context);
        //ViewGroup.LayoutParams.WRAP_CONTENT，自动包裹所有的内容
        window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        window.setFocusable(true);
        //点击 back 键的时候，窗口会自动消失
        window.setBackgroundDrawable(new BitmapDrawable());
        View localView = LayoutInflater.from(context).inflate(R.layout.popuarenagridview, null);
        mygridview = (GridView) localView.findViewById(R.id.lv_pop_grid);
        mygridview.setAdapter(new MyAdapter(context, datas));
        mygridview.setTag(window);
        //设置显示的视图
        window.setContentView(localView);
    }

    public void dismiss() {
        window.dismiss();
    }

    /**
     * @param xOff x轴（左右）偏移
     * @param yOff y轴（上下）偏移
     */
    public void setOff(int xOff, int yOff) {
        this.xOff = xOff;
        this.yOff = yOff;
    }

    /**
     * @param paramView 点击的按钮
     */
    public void show(View paramView) {
        //该count 是手动调整窗口的宽度
//        window.setWidth(paramView.getWidth() * count);
        //设置窗口显示位置, 后面两个0 是表示偏移量，可以自由设置
        window.showAsDropDown(paramView, xOff, yOff);
        //更新窗口状态
        window.update();
    }

    class MyAdapter extends BaseAdapter {

        private Context context;
        private List<ArenaTitleBean.DataBean> mDatas;

        public MyAdapter(Context context, List<ArenaTitleBean.DataBean> datas) {
            this.context = context;
            if (datas == null) {
                datas = new ArrayList<>();
            }
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            TextView tvItem;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_arenagrid, null);
                tvItem = (TextView) convertView.findViewById(R.id.tv_item_pw_menu);
                convertView.setTag(tvItem);
            } else {
                tvItem = (TextView) convertView.getTag();
            }
            tvItem.setText(mDatas.get(position).getTitle() + "");
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackItemPosition.onBackPostion(position);
                }
            });
            Debug.e("-------------"+mDatas.get(position).getTitle());
            return convertView;
        }
    }

   public interface OnBackItemPosition {
        void onBackPostion(int position);
    }
}
