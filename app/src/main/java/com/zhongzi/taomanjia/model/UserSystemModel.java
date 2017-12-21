package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/8.
 * 系统消息
 */

public class UserSystemModel {
    public static UserSystemModel getInstance() {
        return UserSystemModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserSystemModel instance = new UserSystemModel();
    }

    private UserSystemModel() {
    }

    /**
     * 获取系统消息
     */
    public void getSystemMessage(HttpArrayObserver<UserSystemRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable= RetrofitUtil.getApiService().getSystemMessage("Android");
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }
}
