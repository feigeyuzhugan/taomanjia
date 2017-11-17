package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/11/14.
 * 获取广告位banner的数据
 */

public class BannerInfoModel {

    public static BannerInfoModel getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final BannerInfoModel instance = new BannerInfoModel();
    }

    private BannerInfoModel() {
    }

    /**
     * @param observer
     * @param lifecycleSubject
     */
    public void getBannerInfos(HttpArrayObserver<BannerInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getBannerInfoRes();//如果需要嵌套请求的话，则在后面加入flatMap进行处理
//        observable.
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

}
