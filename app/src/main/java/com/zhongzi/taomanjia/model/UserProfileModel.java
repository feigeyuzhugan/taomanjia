package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/1.
 * 个人资料
 */

public class UserProfileModel {
    public static UserProfileModel getInstance() {
        return UserProfileModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserProfileModel instance = new UserProfileModel();
    }

    private UserProfileModel() {
    }

    /**
     * 获取个人资料信息
     * @param username
     * @param observer
     * @param lifecycleSubject
     */
    public void getUserProfile(String username, HttpObserver<UserProfileRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable= RetrofitUtil.getApiService().getUserProfile(username);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

}
