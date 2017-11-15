package com.zhongzi.taomanjia.presenter;

import android.util.Log;

import com.zhongzi.taomanjia.model.BannerInfoModel;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iPresenter.IBannerPresenter;

import java.util.List;

import javax.security.auth.login.LoginException;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BannerPresenter extends BasePresenter<IBannerPresenter> {

    private static final String TAG = BannerPresenter.class.getSimpleName();
    private BannerInfoModel mBannerInfoModel;

    public BannerPresenter(IBannerPresenter iBannerPresenter) {
        super(iBannerPresenter);
        mBannerInfoModel = BannerInfoModel.getInstance();
    }

    public void getBannerInfo(){
        mBannerInfoModel.getBannerInfos(new HttpObserver<BannerInfoRes>() {
            @Override
            public void onNext(String title, List<BannerInfoRes> list) {
                Log.e(TAG, "onNext: "+list.get(0).toString());
                mIView.getBannerInfoSuccess(list);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        }, mIView.getLifeSubject());
    }
}
