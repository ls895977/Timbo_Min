package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.tool.GlideImageLoader;
import com.example.lishan.timbo_min.ui.home.latestactivities.Act_Activity_Content;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 培训机构
 * Created by lishan on 2018/1/22.
 */

public class Act_TrainingInstitutions extends BaseAct {
    private Banner myBanaer;

    @Override
    public int initLayoutId() {
        return R.layout.act_traininginstitutions;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.TrainingInstitutions_back);
        myBanaer = getView(R.id.TrainingInstitutions_banner);
        setOnClickListener(R.id.traininginstitutions_huodong);
        setOnClickListener(R.id.traininginstitutions_shipin);
        setOnClickListener(R.id.traininginstitutions_xueyuan);
        setOnClickListener(R.id.traininginstitutions_qiye);
        setOnClickListener(R.id.traininginstitutions_shiping);
        setOnClickListener(R.id.traininginstitutions_xueyuan1);
        setOnClickListener(R.id.traininginstitutions_tuandui1);
        setOnClickListener(R.id.traininginstitutions_tuandui);
        setOnClickListener(R.id.my_trainingbutton);
        setOnClickListener(R.id.traininginstitutions_lianxiwo);
    }

    @Override
    public void initData() {
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        myBanaer.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.TrainingInstitutions_back:
                finish();
                break;
            case R.id.traininginstitutions_huodong://企业活动
            case R.id.traininginstitutions_qiye:
                startAct(Act_TraininginstitutionsTuandui.class);
                break;
            case R.id.traininginstitutions_shipin://教育视频
            case R.id.traininginstitutions_shiping:
                startAct(Act_EducationalVideo.class);
                break;
            case R.id.traininginstitutions_xueyuan://教育演员
            case R.id.traininginstitutions_xueyuan1:
                startAct(Act_ExcellentStudents.class);
                break;
            case R.id.traininginstitutions_tuandui://团队
            case R.id.traininginstitutions_tuandui1:
                startAct(Act_OurTeam.class);
                break;
            case R.id.traininginstitutions_lianxiwo://联系我们
                startAct(Act_ContactUs.class);
                break;
            case R.id.my_trainingbutton:
                startAct(Act_Enroll.class);
                break;

        }
    }
}
