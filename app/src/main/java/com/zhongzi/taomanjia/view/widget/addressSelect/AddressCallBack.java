package com.zhongzi.taomanjia.view.widget.addressSelect;

import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;

/**
 * Created by Administrator on 2017/12/1.
 */

public interface AddressCallBack {
    public void selectProvince(AddressProvinceRes province);
    public void selectCity(AddressCityRes city);
    public void selectDistrict(AddressDistrictRes district);
}
