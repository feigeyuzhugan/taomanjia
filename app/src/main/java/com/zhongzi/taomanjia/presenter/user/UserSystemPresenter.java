package com.zhongzi.taomanjia.presenter.user;

import com.zhongzi.taomanjia.model.BannerInfoModel;
import com.zhongzi.taomanjia.model.UserSystemModel;
import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.presenter.BannerPresenter;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IBannerView;
import com.zhongzi.taomanjia.presenter.iView.IUserSystemView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */

public class UserSystemPresenter extends BasePresenter<IUserSystemView> {

    private static final String TAG = UserSystemPresenter.class.getSimpleName();
    private UserSystemModel mUserSystemModel;

    public UserSystemPresenter(IUserSystemView iUserSystemView) {
        super(iUserSystemView);
        mUserSystemModel = UserSystemModel.getInstance();
    }

    /**
     * 获取系统消息
     */
    public void getMessage(){
        mUserSystemModel.getSystemMessage(new HttpArrayObserver<UserSystemRes>() {
            @Override
            public void onNext(String title, List<UserSystemRes> t) {
                mIView.success(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
}
