package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

/**
 * Created by Administrator on 2017/11/16.
 *
 */

public interface IRegView extends IBaseView{
    /**
     * 发送手机号，返回的验证码
     * @param
     */
//    void postPhonecode(RegPhoneNumCheckRes regPhoneNumCheckRes);
    void regSuccess(RegUserRes regUserRes);//注册成功
    void next();//下一页

}
