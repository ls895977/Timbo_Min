package com.example.lishan.timbo_min.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.Dlg_RegisterChoseBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.dialog.Dlg_RegisterChose;
import com.example.lishan.timbo_min.dialog.Dlg_RegisterClass;
import com.example.lishan.timbo_min.dialog.Dlg_RegisterNoChose;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.CountdownButton;
import com.google.gson.Gson;
import com.example.lishan.timbo_min.bean.JsonBean;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.GetJsonDataUtil;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 注册
 * Created by lishan on 2017/12/9.
 */

public class Act_Register extends BaseAct {
    private SVProgressHUD mSVProgressHUD;
    private CountdownButton code;
    private HttpReqest httpReqest;
    private EditText phone, ed_code, pwd, SchoolName;
    private Gson gson;
    private CodeBean codeBean;
    private ACache aCache;
    private TextView shen, shi, qu, nianjibanji;
    private CheckBox chose;
    private Dlg_RegisterChose School;//学校选择
    private Dlg_RegisterNoChose NoChose;//创建学校
    private static Dlg_RegisterClass classDialog;//班级查询

    @Override
    public int initLayoutId() {
        return R.layout.act_register;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.rg_back);
        setOnClickListener(R.id.rg_next_step);
        mSVProgressHUD = new SVProgressHUD(context);
        code = getViewAndClick(R.id.countdownButton);
        httpReqest = new HttpReqest();
        phone = getView(R.id.register_phone);
        ed_code = getView(R.id.register_code);
        pwd = getView(R.id.register_pwd);
        SchoolName = getView(R.id.register_SchoolName);
        setOnClickListener(R.id.register_addr);
        shen = getView(R.id.rg_shen);
        shi = getView(R.id.rg_shi);
        qu = getView(R.id.rg_qu);
        chose = getView(R.id.register_chose);
        nianjibanji = getView(R.id.register_nianjibanji);
        nianjibanji.setVisibility(View.GONE);
    }

    @Override
    public void initData() {
        gson = new Gson();
        aCache = ACache.get(context);
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
        SchoolName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (SchoolName.getText().toString().length() <= 0) {
                    return;
                }
                PostsearchSchool(SchoolName.getText().toString());
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
        switch (v.getId()) {
            case R.id.rg_back:
                finish();
                break;
            case R.id.rg_next_step://下一步
                postDwon();
                break;
            case R.id.countdownButton://发送验证码
                PostBackCode();
                break;
            case R.id.register_addr://地址
                showPickerView();
                break;
        }
    }

    /**
     * 发送验证码
     */
    public void PostBackCode() {
        if (TextUtils.isEmpty(phone.getText().toString())) {
            MyToast.show(context, "请输入手机号码！");
            return;
        }
        if (phone.getText().toString().length() == 18) {
            MyToast.show(context, "请输入手机号码位数错误！");
            return;
        }
        mSVProgressHUD.showWithStatus("发送中...");
        HashMap hashMap = new HashMap();
        hashMap.put("phone", phone.getText().toString());
        httpReqest.HttpPost("i=1&c=entry&do=signup_send_captcha&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---------" + response.body());
                mSVProgressHUD.dismiss();
                if (response.body().contains("204")) {
                    MyToast.show(context, "该手机号已注册！");
                    return;
                }
                codeBean = gson.fromJson(response.body(), CodeBean.class);
                if (codeBean.getSession_id() != null)
                    aCache.put("session_id", codeBean.getSession_id());
                MyToast.show(context, "短信发送成功！");
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }

    /**
     * 请求搜索到的学校
     */
    Dlg_RegisterChoseBean choseBean;

    public void PostsearchSchool(String search) {
        if (TextUtils.isEmpty(SchoolName.getText().toString())) {
            MyToast.show(context, "请输入要搜索的内容！");
            return;
        }
        mSVProgressHUD.showWithStatus("搜索中...");
        HashMap hashMap = new HashMap();
        hashMap.put("school_name", search);
        httpReqest.HttpPost("i=1&c=entry&do=search_school&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                School = new Dlg_RegisterChose(context);
                String st = response.body();
                mSVProgressHUD.dismiss();
                if (st.contains("204")) {
                    MyToast.show(context, "未搜到你要的内容！");
                    NoChose = new Dlg_RegisterNoChose(context, new Dlg_RegisterNoChose.onSchoolBack() {
                        @Override
                        public void onBackSchoolId(int school_id, String school_name, String nianji, String banji) {//返回创建成功
                            aCache.put("school_id", String.valueOf(school_id));
                            //班级
                            classDialog = new Dlg_RegisterClass(context);
                            classDialog.setData(school_name, nianji, banji, String.valueOf(school_id), onClassBack);
                            classDialog.show();
                        }
                    });
                    NoChose.show();
                } else {
                    choseBean = gson.fromJson(response.body(), Dlg_RegisterChoseBean.class);
                    Debug.e("--学校---" + response.body());
                    MyToast.show(context, "搜索成功！");
                    School.setBean(choseBean, new Dlg_RegisterChose.onBackChose() {
                        @Override
                        public void onBackItem(int position) {//选择学校
                            aCache.put("school_id", String.valueOf(choseBean.getData().get(position).getSchool_id()));
                            //班级
                            classDialog = new Dlg_RegisterClass(context);
                            classDialog.setData((choseBean.getData().get(position).getSchool_name()), "", "", String.valueOf(choseBean.getData().get(position).getSchool_id()), onClassBack);
                            classDialog.show();
                        }

                        @Override
                        public void onClick() {//点击我要创建
                            School.dismiss();
                            NoChose = new Dlg_RegisterNoChose(context, new Dlg_RegisterNoChose.onSchoolBack() {
                                @Override
                                public void onBackSchoolId(int school_id, String school_name, String nianji, String banji) {//返回创建成功
                                    aCache.put("school_id", String.valueOf(school_id));
                                    //班级
                                    classDialog = new Dlg_RegisterClass(context);
                                    classDialog.setData(school_name, nianji, banji, String.valueOf(school_id), onClassBack);
                                    classDialog.show();
                                }
                            });
                            NoChose.show();
                        }
                    });
                    School.show();
                }
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }

    /**
     * 班级dialog弹窗返回点击事件
     */
    Dlg_RegisterClass.OnClassBack onClassBack = new Dlg_RegisterClass.OnClassBack() {
        @Override
        public void onBackData(String nianji, String banji) {//查到数据的情况
            classDialog.dismiss();
            nianjibanji.setVisibility(View.VISIBLE);
            nianjibanji.setText(nianji + "年" + banji + "班");

        }

        @Override
        public void onShutDown() {
            classDialog.dismiss();
        }
    };
    private String captcha, city, district;

    /**
     * postDown  下一步
     */
    public void postDwon() {
        if (TextUtils.isEmpty(phone.getText().toString())) {
            MyToast.show(context, "请输入验证码！");
            return;
        }
        if (TextUtils.isEmpty(ed_code.getText().toString())) {
            MyToast.show(context, "请输入验证码！");
            return;
        }
        if (TextUtils.isEmpty(pwd.getText().toString())) {
            MyToast.show(context, "请输入密码！");
            return;
        }
        if (TextUtils.isEmpty(shen.getText().toString())) {
            MyToast.show(context, "请选择地址！");
            return;
        }
        if (TextUtils.isEmpty(SchoolName.getText().toString())) {
            MyToast.show(context, "请输入学校名称！");
            return;
        }
        if (TextUtils.isEmpty(SchoolName.getText().toString())) {
            MyToast.show(context, "请输入学校名称！");
            return;
        }
        if (chose.isChecked() != true) {
            MyToast.show(context, "请认真阅读用户协议！");
            return;
        }
        aCache.put("type", "0");//类型（0学生1老师2企业
        aCache.put("phone", phone.getText().toString());//电话号码
        if (captcha != null) {
            aCache.put("captcha", captcha);//省
        }
        if (city != null) {
            aCache.put("city", city);//市
        }
        if (city != null) {
            aCache.put("district", district);//区
        }
        aCache.put("captcha", ed_code.getText().toString());//验证码
        aCache.put("password", pwd.getText().toString());//密码
        aCache.put("SchoolName", SchoolName.getText().toString());//学校名称
        startAct(Act_RG_Perfect_information.class);
    }

    /**
     * 地址选择器
     */
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了

                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;
            }
        }
    };

    private String addr;

    private void showPickerView() {// 弹出选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                addr = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                captcha = options1Items.get(options1).getPickerViewText();
                city = options2Items.get(options1).get(options2);
                district = options3Items.get(options1).get(options2).get(options3);
                shen.setText(options1Items.get(options1).getPickerViewText());
                shi.setText(options2Items.get(options1).get(options2));
                qu.setText(options3Items.get(options1).get(options2).get(options3));
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {
                    City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

}
