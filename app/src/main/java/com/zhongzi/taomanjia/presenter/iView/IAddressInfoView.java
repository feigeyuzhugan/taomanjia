package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 * 地址
 */

public interface IAddressInfoView extends IBaseView{

    void success(List<AddressInfoRes> list);
    void deleteSuccess(String str);
}
