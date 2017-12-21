package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.user.BankcardRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

/**
 * Created by Administrator on 2017/12/8.
 */

public interface IBankcardView extends IBaseView{
    void succes(BankcardRes bankcardRes);
}
