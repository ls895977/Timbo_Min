package com.example.lishan.timbo_min.common;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by User on 2016/7/26.
 */
public class ComantUtils {
    public static String MyUrl = "http://wz.kulehu.com/app/index.php?";
    //    public static String MyUrl="http://xiaoshuteng.cn/app/index.php?";
    public static String SignInUrl = "i=1&c=entry&do=signin&m=ted_users";
    /**
     *  成长资讯分类
     */
    public static String Basning_ted_grow_news_Url = "i=1&c=entry&do=category&m=ted_grow_news";
    /**
     *  成长资讯列表
     */
    public static String Basning_ted_grow_news_List_Url = "i=1&c=entry&do=list&m=ted_grow_news";




    public static int PAGE_ID = 0;
    public static int Addr_Stats = 10;
    public static int Addr_Result = 5;
    public static int PHOTO_CAMERA = 1;
    public static String imagmHadr = "http://zp.wxtah.com/UpLoadFile/image/";

    /**
     * URI得到路劲
     *
     * @param uri
     * @param act
     * @return
     */
    public static String getPath(Uri uri, Activity act) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = act.managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    /**
     * 根据地址得到缩略图
     *
     * @param videoPath
     * @return
     */
    //根据路径得到视频缩略图
    public static Bitmap getVideoPhoto(String videoPath) {
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        media.setDataSource(videoPath);
        Bitmap bitmap = media.getFrameAtTime();
        return bitmap;
    }

    public static String getFilePath(final Context context, final Uri uri ) {
        if ( null == uri ) return null;

        final String scheme = uri.getScheme();
        String data = null;

        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = context.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
    /**
     * 转成文本，去掉引号
     */
    public static RequestBody toRequestBody(String value) {
        return MultipartBody.create(MediaType.parse("text/plain"), value);
    }
}
