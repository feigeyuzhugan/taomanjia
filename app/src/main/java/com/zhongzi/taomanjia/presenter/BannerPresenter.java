package com.zhongzi.taomanjia.presenter;

import android.util.Log;

import com.zhongzi.taomanjia.model.BannerInfoModel;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IBannerView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BannerPresenter extends BasePresenter<IBannerView> {

    private static final String TAG = BannerPresenter.class.getSimpleName();
    private BannerInfoModel mBannerInfoModel;

    public BannerPresenter(IBannerView iBannerPresenter) {
        super(iBannerPresenter);
        mBannerInfoModel = BannerInfoModel.getInstance();
    }

    public void getBannerInfo(){
        mBannerInfoModel.getBannerInfos(new HttpArrayObserver<BannerInfoRes>() {
            @Override
            public void onNext(String title, List<BannerInfoRes> list) {
//                Log.e(TAG, "onNext: "+list.get(0).toString());
                mIView.getBannerInfoSuccess(list);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        }, mIView.getLifeSubject());
    }
}
