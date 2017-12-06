package com.zhongzi.taomanjia.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressEvent;
import com.zhongzi.taomanjia.utils.camera.CameraUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.MainActivity;
import com.zhongzi.taomanjia.view.widget.MaterialDialog;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/27.
 * 针对对话框的工具类
 */

public class MaterialDialogUtils {
 /*   private static MaterialDialog materialDialog;
    private static MaterialDialogUtils materialDialogUtils;
    private MaterialDialogUtils(Context context){
        materialDialog=new MaterialDialog(context);
    }
    public static MaterialDialogUtils getInstence(Context context){
        if (materialDialogUtils==null){
            materialDialogUtils=new MaterialDialogUtils(context);
        }
        return materialDialogUtils;
    }*/

    /**
     * 权限
     * @param title
     * @param message
     * @param activity
     */
    public static void showPermissionDialog(String title,String message, final Activity activity){
        final MaterialDialog materialDialog=new MaterialDialog(activity);
        materialDialog.setMessage(message);
        materialDialog.setTitle(title);
        materialDialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
            }
        });
        materialDialog.setPositiveButton("去设置页面", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtil.startApplicationDetailsSettings(activity, BaseConstants.PERMISSION_CAMERA);
                materialDialog.dismiss();
            }
        });
        materialDialog.show();
    }

    /**
     * 退出
     * @param title
     * @param message
     * @param activity
     */
    public static void showExitDialog(String title,String message, final Activity activity){
        final MaterialDialog materialDialog=new MaterialDialog(activity);
        materialDialog.setMessage(message);
        materialDialog.setTitle(title);
        materialDialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
            }
        });
        materialDialog.setPositiveButton("退出", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
                materialDialog.dismiss();
            }
        });
        materialDialog.show();
    }
    public static void showCallPhoneDialog(final Uri imageUri, final Activity activity){

        final MaterialDialog materialDialog=new MaterialDialog(activity);
        View view= LayoutInflater.from(activity).inflate(R.layout.dialog_permission_camera,null);
        TextView camera= (TextView) view.findViewById(R.id.dialog_camera);
        TextView photo= (TextView) view.findViewById(R.id.dialog_photo);
        TextView cancel= (TextView) view.findViewById(R.id.dialog_cancel);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("去照相");
                LogUtil.e(imageUri);
                CameraUtils.selectCamera(imageUri,activity);
                materialDialog.dismiss();
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("去相册");
                CameraUtils.selectPhoto(activity);
                materialDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
            }
        });
        materialDialog.setContentView(view);
        materialDialog.show();
    }
    /**
     * 删除
     * @param title
     * @param message
     * @param activity
     */
    public static void showRemoveDialog(String title,String message, final Activity activity){
        final MaterialDialog materialDialog=new MaterialDialog(activity);
        materialDialog.setMessage(message);
        materialDialog.setTitle(title);
        materialDialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
            }
        });
        materialDialog.setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusUtil.postEvent(new AddressEvent(BaseConstants.DIALOG_REMOVE));
                materialDialog.dismiss();
            }
        });
        materialDialog.show();
    }
}
