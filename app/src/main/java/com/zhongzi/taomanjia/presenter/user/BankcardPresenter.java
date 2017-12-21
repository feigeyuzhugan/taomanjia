package com.zhongzi.taomanjia.presenter.user;

import com.zhongzi.taomanjia.model.BankcardModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.res.user.BankcardRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IBankcardView;

/**
 * Created by Administrator on 2017/12/8.
 */

public class BankcardPresenter extends BasePresenter<IBankcardView> {
    private BankcardModel mBankcardModel;
    String name=null;
    public BankcardPresenter(IBankcardView iBankcardView){
        super(iBankcardView);
        mBankcardModel=BankcardModel.getInstance();
        name= UserInfoSP.getInstance().getUserName();
    }

    public void getMyBankInfo(){
        mBankcardModel.getMyBankInfo(name, new HttpObserver<BankcardRes>() {
            @Override
            public void onNext(String title, BankcardRes bankcardRes) {
                mIView.succes(bankcardRes);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
}
