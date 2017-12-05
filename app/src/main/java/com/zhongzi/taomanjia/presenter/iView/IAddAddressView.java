package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfo;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 * 添加地址
 */

public interface IAddAddressView extends IBaseView{
    void allProvince(List<AddressProvinceRes> list);//省的信息
    void allCity(List<AddressCityRes> list);//市的信息
    void allDistrict(List<AddressDistrictRes> list);//区的信息

//    AddressInfo userInfo();//
    void addSuccess(String mes);

}
