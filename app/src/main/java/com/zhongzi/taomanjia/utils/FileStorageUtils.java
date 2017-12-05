package com.zhongzi.taomanjia.utils;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/28.
 *
 */
public class FileStorageUtils {

//    private File cropIconDir;
//    private File iconDir;
    private String cropIconDir;
    private String iconDir;
    private String filepath=FileUtil.getExternalStorageDirectory()+"/" + "tmj";
    private String tmjcrop ="/tmjcrop";
    private String tmjicon ="/tmjicon";

    public FileStorageUtils() {
        if (FileUtil.isSDCardAvailable()) {
            FileUtil.generateDirectory(filepath,tmjcrop);
            cropIconDir =filepath+tmjcrop;
           FileUtil.generateDirectory(filepath,tmjicon);
            iconDir =filepath+tmjicon;
        }else {
            ToastUtil.show("没有sdk");
        }
    }

    /**
     * 裁剪地址
     * @return
     */
    public File createCropFile() {
        String fileName = "";
        if (cropIconDir != null) {
            fileName = UUID.randomUUID().toString() + ".png";
        }
        FileUtil.generateDirectory(cropIconDir,fileName);
        return  new File(cropIconDir+fileName);
    }

    /**
     * 照相的地址
     * @return
     */
    public File createIconFile() {
        String fileName = "";
        if (iconDir != null) {
            fileName = UUID.randomUUID().toString() + ".png";
        }
        FileUtil.generateDirectory(iconDir,fileName);
        return new File(iconDir+fileName);
    }

    /**
     * 创建一个
     * @param activity
     * @return
     */
    public static Uri createImageUri(Activity activity){
        Uri imageUri=null;
        File file = new FileStorageUtils().createIconFile();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imageUri = FileProvider.getUriForFile(activity, "com.zhongzi.taomanjia.fileprovider", file);//通过FileProvider创建一个content类型的Uri
        } else {
            imageUri = Uri.fromFile(file);
        }
        return imageUri;
    }

}
