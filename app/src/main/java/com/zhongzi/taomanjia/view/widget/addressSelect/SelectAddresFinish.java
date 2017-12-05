package com.zhongzi.taomanjia.view.widget.addressSelect;

import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;

/**
 * Created by Administrator on 2017/12/1.
 * 选择好的接口
 */

public interface SelectAddresFinish {

    /**
     *
     * @param province
     * @param city
     * @param area
     */
    void finish(AddressProvinceRes province, AddressCityRes city, AddressDistrictRes area);
}
