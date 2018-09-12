package com.example.lishan.timbo_min.ui.home.motion;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.ui.home.motion.Act_DetectionResult;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;

/**
 * 检 测您 的体型
 * Created by lishan on 2018/1/11.
 */

public class Act_Sign extends BaseAct {
    private RadioGroup myGroup;
    private EditText age,gongjin,limi;
    @Override
    public int initLayoutId() {
        return R.layout.act_sign;
    }

    @Override
    public void initView() {
        setHeaderLeft(R.mipmap.icon_mygrowth_title);
        setTitle(R.string.Act_Sign_title);
        setOnClickListener(R.id.sign_click1s);

        age=getView(R.id.sign_age);
        gongjin=getView(R.id.sign_gongjin);
        limi=getView(R.id.sign_shenggao);
        myGroup=getView(R.id.sign_sex);
    }
    String sex="";
    @Override
    public void initData() {
        myGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Debug.e("-------"+checkedId);
                if(checkedId==3){
                    sex="男";
                }else {
                    sex="女";
                }
            }
        });
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
                switch (v.getId()){
                    case R.id.sign_click1s:
                        if(TextUtils.isEmpty(age.getText().toString())){
                            MyToast.show(context,"请输入年龄");
                            return;
                        }
                        if(TextUtils.isEmpty(gongjin.getText().toString())){
                            MyToast.show(context,"请输入体重");
                            return;
                        }
                        if(TextUtils.isEmpty(limi.getText().toString())){
                            MyToast.show(context,"请输入身高");
                            return;
                        }
                        if(TextUtils.isEmpty(sex)){
                            MyToast.show(context,"请选择性别");
                            return;
                        }
                        Intent intent=new Intent();
                        intent.putExtra("age",age.getText().toString());
                        intent.putExtra("gongjin",gongjin.getText().toString());
                        intent.putExtra("limi",limi.getText().toString());
                        intent.putExtra("sex",sex);
                        startAct(intent,Act_DetectionResult.class);
                        break;
                }
    }
}
