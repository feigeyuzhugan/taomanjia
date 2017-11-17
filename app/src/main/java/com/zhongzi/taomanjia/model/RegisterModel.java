package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCommitEvent;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/11/17.
 * 注册界面的
 */
public class RegisterModel {

    public static RegisterModel getInstance() {
        return RegisterModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final RegisterModel instance = new RegisterModel();
    }

    private RegisterModel() {
    }

    /**
     *  发送验证码获取
     * @param mobile 手机号
     * @param type 类型是注册
     * @param observer
     * @param lifecycleSubject
     */
    public void postPhoneNum(String mobile, String type, HttpObserver<RegPhoneNumCheckRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable= RetrofitUtil.getApiService().postRegPhoneNumCheckRes(mobile,type);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

    /**
     * 注册用户
     * @param map
     * @param observer
     * @param lifecycleSubject
     */
    public void postRegisterUser(Map<String,String> map, HttpObserver<RegUserRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable=RetrofitUtil.getApiService().postRegUserRes(map);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

}
