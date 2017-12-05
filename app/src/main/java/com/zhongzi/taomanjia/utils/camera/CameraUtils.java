package com.zhongzi.taomanjia.utils.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Base64;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.FileStorageUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by Administrator on 2017/11/28.
 */

public class CameraUtils {

    public static void selectCamera(Uri imageUri, Activity activity) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        }
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
        activity.startActivityForResult(intent, BaseConstants.REQUEST_SELECT_CAMERA);
    }

    /**
     * 选择图库
     */
    public static void selectPhoto(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, BaseConstants.REQUEST_PICK_IMAGE);
    }

    /**
     * 裁剪
     */
    public static void cropPhoto(Uri imageUri, Activity activity) {
        try {
//            File file = new FileStorageUtils().createCropFile();
            LogUtil.e(imageUri);
            Intent intent = new Intent("com.android.camera.action.CROP");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            intent.setDataAndType(imageUri, "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            intent.putExtra("outputX", 360);// 输出图片大小
            intent.putExtra("outputY", 360);
            intent.putExtra("return-data", false);
            intent.putExtra("noFaceDetection", true);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            //广播刷新相册
//            Intent intentBc = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//            intentBc.setData(imageUri);
//            activity.sendBroadcast(intentBc);
            activity.startActivityForResult(intent, BaseConstants.REQUEST_PICTURE_CUT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 选择完照片之后
     */
    public static Uri selectPhoto(Intent data,Activity activity){
//        String path=null;

        if (Build.VERSION.SDK_INT >= 19) {
            LogUtil.e("======图片选择");
            return handleImageOnKitKat(data,activity);
        } else {
            return handleImageBeforeKitKat(data,activity);
        }
    }

    /**
     * KitKat版本之前
     * @param data
     */
    private static Uri handleImageBeforeKitKat(Intent data,Activity activity) {
        Uri imageUri = data.getData();
        return getImagePath(imageUri, null,activity);
    }

    /**
     * 大于19
     * @param data
     */
    @TargetApi(19)
    private static Uri handleImageOnKitKat(Intent data,Activity activity) {
        Uri imagePath = null;
        Uri imageUri = data.getData();
        if (DocumentsContract.isDocumentUri(activity, imageUri)) {
            //如果是document类型的uri,则通过document id处理
            String docId = DocumentsContract.getDocumentId(imageUri);
            if ("com.android.providers.media.documents".equals(imageUri.getAuthority())) {
                String id = docId.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection,activity);
            } else if ("com.android.downloads.documents".equals(imageUri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null,activity);
            }
        } else if ("content".equalsIgnoreCase(imageUri.getScheme())) {
            //如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(imageUri, null,activity);
        } else if ("file".equalsIgnoreCase(imageUri.getScheme())) {
            //如果是file类型的Uri,直接获取图片路径即可
            File file=new File(imageUri.getPath());
            imagePath = Uri.fromFile(file);
        }
        LogUtil.e("相片"+imagePath);
        return imagePath;
    }

    private static Uri getImagePath(Uri uri, String selection,Activity activty) {
        String path = null;
        //通过Uri和selection老获取真实的图片路径
        Cursor cursor = activty.getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        File file=new File(path);
        return Uri.fromFile(file);
    }

    /**
     * 裁剪完--
     * 上传
     * finish
     */
    public static void cropPhotoFinish(Intent data){
        try {
            if (data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                String uploadBuffer = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT)); // 进行Base64编码
                String filetext = uploadBuffer;
                String fileType = "png";
//                upLoadUserPic(filetext, fileType, bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
