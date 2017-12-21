package com.zhongzi.taomanjia.presenter.user;

import com.zhongzi.taomanjia.model.UserProfileModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IUserProfileView;

/**
 * Created by Administrator on 2017/12/11.
 */

public class UserProfilePresenter extends BasePresenter<IUserProfileView> {
    private static final String TAG = UserSystemPresenter.class.getSimpleName();
    private UserProfileModel mUserProfileModel;
    private String name;

    public UserProfilePresenter(IUserProfileView iUserProfileView) {
        super(iUserProfileView);
        mUserProfileModel = UserProfileModel.getInstance();
        name= UserInfoSP.getInstance().getUserName();
    }

    public void getProfileData(){
        mUserProfileModel.getUserProfile(name, new HttpObserver<UserProfileRes>() {
            @Override
            public void onNext(String title, UserProfileRes profileRes) {
                mIView.success(profileRes);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
}
