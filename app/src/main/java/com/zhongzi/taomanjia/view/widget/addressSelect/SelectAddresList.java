package com.zhongzi.taomanjia.view.widget.addressSelect;

import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 * 选择具体地区的接口
 */

public interface SelectAddresList {
//    void allProvinceRes();//获取所有省
    void allCity(String provinceId);//获取所有的市

    void addDistrict(String cityId);//所有的地区

}
