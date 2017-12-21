package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.entity.res.user.BankcardRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/8.
 * 银行卡
 */

public class BankcardModel {
    public static BankcardModel getInstance() {
        return BankcardModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final BankcardModel instance = new BankcardModel();
    }

    private BankcardModel() {
    }

    /**
     * 添加银行卡
     * @param map
     * @param observer
     * @param lifecycleSubject
     */
    public void addMyBankInfo(Map<String,String> map, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().addMyBankInfo(map);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    public void getMyBankInfo(String userName, HttpObserver<BankcardRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyBankInfo(userName);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

}
