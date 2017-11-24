package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

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
     *
     * @param userid 用户的id
     * @param observer
     * @param lifecycleSubject
     */
    public void postUserinfo(String userid, HttpObserver<UserInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable= RetrofitUtil.getApiService().postUserInfo(userid);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

}
