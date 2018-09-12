package com.example.lishan.timbo_min.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.Enterprise_RegistrationBean;
import com.example.lishan.timbo_min.bean.JsonBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.ui.Act_Enterprise_Data;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.GetJsonDataUtil;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lishan on 2017/12/10.
 */

public class Act_Enterprise_Registration extends BaseAct {
    private EditText phone, pwd, pwd1, contacts, code;
    private String sex = "";
    private RadioGroup myRadio;
    private TextView shen, shi;

    @Override
    public int initLayoutId() {
        return R.layout.act_enterprise_registration;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.rg_terenzhuce);
        setOnClickListener(R.id.er_back);
        setOnClickListener(R.id.er_next_step);
        phone = getView(R.id.enterprise_phone);
        pwd = getView(R.id.enterprise_pwd);
        pwd1 = getView(R.id.enterprise_pwd1);
        contacts = getView(R.id.enterprise_Contacts);
        myRadio = getView(R.id.enterprise_sex);
        setOnClickListener(R.id.Enterprise_Registration_addr);
        shen = getView(R.id.enterprise_Registration_shen);
        shi = getView(R.id.enterprise_Registration_shi);
        code = getView(R.id.enterprise_code);
        setOnClickListener(R.id.countdownButton);
    }

    @Override
    public void initData() {
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
        myRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == 3) {
                    sex = "男";
                } else {
                    sex = "女";
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
        switch (v.getId()) {
            case R.id.rg_terenzhuce://个人注册
                finish();
                break;
            case R.id.er_back:
                finish();
                break;
            case R.id.er_next_step:
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    MyToast.show(context, "请输入手机号码");
                    return;
                }
                if (TextUtils.isEmpty(pwd.getText().toString())) {
                    MyToast.show(context, "请输入密码一");
                    return;
                }
                if (TextUtils.isEmpty(pwd1.getText().toString())) {
                    MyToast.show(context, "请输入密码二");
                    return;
                }
                if (!pwd.getText().toString().equals(pwd1.getText().toString())) {
                    MyToast.show(context, "两次输入的密码不一至");
                    return;
                }
                if (TextUtils.isEmpty(shen.getText().toString())) {
                    MyToast.show(context, "请选择机构地址");
                    return;
                }
                if (TextUtils.isEmpty(code.getText().toString())) {
                    MyToast.show(context, "输入验证码");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("pwd", pwd.getText().toString());
                intent.putExtra("shen", shen.getText().toString());
                intent.putExtra("shi", shi.getText().toString());
                intent.putExtra("contacts", contacts.getText().toString());
                intent.putExtra("code", code.getText().toString());
                intent.putExtra("sex", sex);
                startAct(intent, Act_Enterprise_Data.class);
                break;
            case R.id.countdownButton:
                PostBackCode();
                break;
            case R.id.Enterprise_Registration_addr://机构地址
                showPickerView();
                break;
        }
    }

    private SVProgressHUD mSVProgressHUD;
    private ACache aCache;

    /**
     * 发送验证码
     */
    public void PostBackCode() {
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(context);
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
        HttpReqest httpReqest = new HttpReqest();
        httpReqest.HttpPost("i=1&c=entry&do=signup_send_captcha&m=ted_users", hashMap,aCache.getAsString("session_id"), new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                Debug.e("----------成功" + response.body());
                Enterprise_RegistrationBean codeBean = gson.fromJson(response.body(), Enterprise_RegistrationBean.class);
                if (codeBean.getError_code().equals("200")) {
                    MyToast.show(context, "短信发送成功！");
                    aCache.put("session_id", codeBean.getSession_id());
                } else {
                    MyToast.show(context, codeBean.getError_message());
                }
                mSVProgressHUD.dismiss();
            }
            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
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
                shen.setText(options1Items.get(options1).getPickerViewText());
                shi.setText(options2Items.get(options1).get(options2));
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器*/
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
//        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
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
