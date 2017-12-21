package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

/**
 * Created by Administrator on 2017/12/11.
 * 个人资料
 */

public interface IUserProfileView extends IBaseView {
    void success(UserProfileRes profileRes);
}
