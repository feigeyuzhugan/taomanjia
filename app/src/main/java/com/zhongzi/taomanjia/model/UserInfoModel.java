package com.zhongzi.taomanjia.model;

import android.hardware.usb.UsbRequest;
import android.net.Uri;

import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;
import com.zhongzi.taomanjia.utils.FileUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/11/23.
 */

public class UserInfoModel {
    public static UserInfoModel getInstance() {
        return UserInfoModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserInfoModel instance = new UserInfoModel();
    }

    private UserInfoModel() {
    }

    /**
     * @param userid           用户的id
     * @param observer
     * @param lifecycleSubject
     */
    public void postUserinfo(String userid, HttpObserver<UserInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().postUserInfo(userid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 头像上传
     * @param userid           用户的id
     * @param observer
     * @param lifecycleSubject
     */
    public void upLoadPhoto(String userid, String uri, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        LogUtil.e(uri);
        String path=uri.substring("file://".length());
        File file = new File(path);
        LogUtil.e(file.getAbsoluteFile());
        RequestBody userNameBody = RequestBody.create(MediaType.parse("text/plain"), userid);
        // 创建 RequestBody，用于封装 请求RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        Observable observable = RetrofitUtil.getApiService().uploadImage( body,userNameBody);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

}
