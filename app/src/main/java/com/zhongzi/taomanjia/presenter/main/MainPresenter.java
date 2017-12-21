package com.zhongzi.taomanjia.presenter.main;

import com.zhongzi.taomanjia.model.BannerInfoModel;
import com.zhongzi.taomanjia.presenter.BannerPresenter;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IBannerView;
import com.zhongzi.taomanjia.presenter.iView.IMainView;

/**
 * Created by Administrator on 2017/12/20.
 */

public class MainPresenter extends BasePresenter<IMainView> {
    private static final String TAG = BannerPresenter.class.getSimpleName();
//    private BannerInfoModel mBannerInfoModel;

    public MainPresenter(IMainView iMainView) {
        super(iMainView);
//        mBannerInfoModel = BannerInfoModel.getInstance();
    }

    public void test(){
        mIView.text();
    }
}
