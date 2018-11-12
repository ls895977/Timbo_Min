package com.example.lishan.timbo_min.ui.home;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.BusinessShopGridAdapter;
import com.example.lishan.timbo_min.adapter.ProblemGridAdapter;
import com.example.lishan.timbo_min.bean.HealthPageDetailsBean;
import com.example.lishan.timbo_min.bean.ProblemFileBean;
import com.example.lishan.timbo_min.bean.ProblemImgBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.dialog.Dlg_PhotoAlbum;
import com.example.lishan.timbo_min.dialog.Dlg_Photograph;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.permission.RxPermissions;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.functions.Consumer;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * Created by lishan on 2017/12/23.
 */

public class Act_I_Know extends BaseAct implements AdapterView.OnItemClickListener, BusinessShopGridAdapter.onBackImgShut, Dlg_Photograph.OnClick {
    private GridView myGridView;
    private HealthPageDetailsBean data;
    private ACache aCache;
    private CircleImageView hader, myHader;
    private TextView nickName, contentText, myNickName;
    private EditText answer;
    private Dlg_Photograph photo;
    private RxPermissions rxPermissions;
    public SVProgressHUD mSVProgressHUD;
    private HttpReqest httpReqest;
    private String cate_id;
    private String aid;

    @Override
    public int initLayoutId() {
        return R.layout.act_i_know;
    }

    @Override
    public void initView() {
        hideHeader();
        myGridView = getView(R.id.i_know_gridView);
        setOnClickListener(R.id.iKnow_back);
        hader = getView(R.id.IKnow_image);
        nickName = getView(R.id.IKnow_nickName);
        contentText = getView(R.id.IKnow_contentText);
        myHader = getView(R.id.IKnow_myHader);
        myNickName = getView(R.id.IKnow_myNickName);
        answer = getView(R.id.IKnow_Answer);
        setOnClickListener(R.id.i_know_problem);
        rxPermissions = new RxPermissions(this);
        aid = getIntent().getStringExtra("aid");
    }

    private BusinessShopGridAdapter adapter;
    List<File> Carmer_file;
    private Gson gson;

    @Override
    public void initData() {
        cate_id = getIntent().getStringExtra("cate_id");
        gson = new Gson();
        httpReqest = new HttpReqest();
        mSVProgressHUD = new SVProgressHUD(this);
        photo = new Dlg_Photograph(this, Act_I_Know.this);
        Carmer_file = new ArrayList<>();
        aCache = ACache.get(context);
        data = (HealthPageDetailsBean) getIntent().getSerializableExtra("data");
        Glide.with(context).load(data.getData().getUserinfo().getCompany_img()).placeholder(R.mipmap.icon_hader).into(hader);
        nickName.setText(data.getData().getUserinfo().getNickname());
        contentText.setText(data.getData().getContent());
        Glide.with(context).load(aCache.getAsString("Company_img")).placeholder(R.mipmap.icon_hader).into(myHader);
        myNickName.setText(aCache.getAsString("company_name"));

        for (int i = 0; i < 1; i++) {
            File file1 = new File("");
            Carmer_file.add(file1);
        }
        adapter = new BusinessShopGridAdapter(this, this);
        adapter.setChannel_info(Carmer_file);
        myGridView.setAdapter(adapter);
        myGridView.setOnItemClickListener(this);
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
            case R.id.iKnow_back:
                finish();
                break;
            case R.id.i_know_problem://提交
                if (TextUtils.isEmpty(answer.getText().toString())) {
                    MyToast.show(context, "请输入您回答的内容！");
                    return;
                }
                subMit();
                break;
        }
    }

    @Override
    public void onBackImgShut(int position) {
        Carmer_file.remove(position);
        if (Carmer_file.get(Carmer_file.size() - 1).getPath().equals("")) {
        } else {
            if (Carmer_file.size() < 8) {
                File file1 = new File("");
                Carmer_file.add(file1);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItem(final int p) {
        rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            switch (p) {
                                case 1://拍照
                                    takePhoto();
                                    photo.dismiss();
                                    break;
                                case 2://从手机相册选择
                                    photo.dismiss();
                                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    startActivityForResult(intent, 3);
                                    break;
                            }
                        } else {
                            photo.dismiss();
                            Toast.makeText(Act_I_Know.this, "请打开拍照权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private int tvPo;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position > 3 || Carmer_file.size() > 4) {
            return;
        }
        photo.show();
        tvPo = position;
    }

    private File currentImageFile;
    private Uri uri;

    protected void takePhoto() {
        File dir = new File(Environment.getExternalStorageDirectory(), "myimage");//在sd下创建文件夹myimage；Environment.getExternalStorageDirectory()得到SD卡路径文件
        if (!dir.exists()) {    //exists()判断文件是否存在，不存在则创建文件
            dir.mkdirs();
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 11);
        } else {
            /**
             * 默认开启后置摄像头
             */
            try {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 默认前置
                intent.putExtra("camerasensortype", 2);
                intent.putExtra("autofocus", true);

                if (android.os.Build.VERSION.SDK_INT < 24) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式在android中，创建文件时，文件名中不能包含“：”冒号
                    String filename = df.format(new Date());
                    currentImageFile = new File(dir, filename + ".jpg");
                    // 从文件中创建uri
                    uri = Uri.fromFile(currentImageFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                } else {
                    // 兼容Android 7.0 使用共享文件的形式
                    ContentValues contentValues = new ContentValues();
                    uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                }

                startActivityForResult(intent, 4);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Debug.e(requestCode + "----requestCode---------resultCode---" + resultCode);
        switch (requestCode) {
            case 3://文件中选择照片
                if (data == null) {
                    return;
                }
                uri = data.getData();
                File file3 = new File(ComantUtils.getPath(uri, Act_I_Know.this));
                backCarme(file3);
                break;
            case 4://拍照完成回调
                if (resultCode == 01) {
                    return;
                }
                File cFile = null;
                if (android.os.Build.VERSION.SDK_INT < 24) {
                    cFile = currentImageFile;
                } else {
                    cFile = new File(ComantUtils.getPath(uri, Act_I_Know.this));
                }
                backCarme(cFile);
                break;
        }
    }


    /**
     * 返回结果做图片压缩
     */
    File lubanFile;
    public void backCarme(File file) {
//新建一个File，传入文件夹目录
        File file1 = new File(Environment.getExternalStorageDirectory(), "mywork");
//判断文件夹是否存在，如果不存在就创建，否则不创建
        if (!file1.exists()) {
            //通过file的mkdirs()方法创建目录中包含却不存在的文件夹
            file1.mkdirs();
        }
        mSVProgressHUD.showWithStatus("上传中...");
        Luban.with(this)
                .load(file)
                .ignoreBy(100)
                .setTargetDir(file1.getPath())
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        lubanFile = file;
                        httpReqest.PosFile("file", "i=1&c=entry&do=upload&m=ted_users", file, FileBack);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("onError--------" + e.getLocalizedMessage());
                    }
                }).launch();
    }

    private List<ProblemImgBean> datas = new ArrayList<>();
    /**
     * 文件上传接口返回值
     */
    ProblemFileBean fileBean1;
    BackString FileBack = new BackString() {
        @Override
        public void onSuccess(Response<String> response) {
            fileBean1 = gson.fromJson(response.body(), ProblemFileBean.class);
            Carmer_file.add(0, lubanFile);
            ProblemImgBean imgBean = new ProblemImgBean(String.valueOf(tvPo), fileBean1.getData().getUrl());
            datas.add(0, imgBean);
            if (Carmer_file.size() == 5) {
                datas.remove(datas.size() - 1);
                Carmer_file.remove(Carmer_file.size() - 1);
            }
            adapter.setChannel_info(Carmer_file);
            adapter.notifyDataSetChanged();
            mSVProgressHUD.dismiss();
            MyToast.show(context, "上传成功！");
        }

        @Override
        public void onError(Response<String> response) {
            mSVProgressHUD.dismiss();
        }
    };

    /**
     * 提交数据
     */
    public void subMit() {
        mSVProgressHUD.showWithStatus("提交中...");
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        body.put("grow_news_img", gson.toJson(datas));
        body.put("skill_id", aid);
        body.put("module", "2");
        body.put("content", answer.getText().toString());
        httpReqest.HttpPost(ComantUtils.Growth_Advisory_release, body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response.body().contains("200")) {
                    MyToast.show(context, "提交成功！");
                    setResult(10);
                    finish();
                }
                mSVProgressHUD.dismiss();

            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }
}
