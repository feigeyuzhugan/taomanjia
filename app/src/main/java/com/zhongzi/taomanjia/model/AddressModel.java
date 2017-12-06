package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/1.
 * 地址
 */

public class AddressModel {
    public static AddressModel getInstance() {
        return AddressModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final AddressModel instance = new AddressModel();
    }

    private AddressModel() {
    }

    /**
     * 省的信息
     * @param observer
     * @param lifecycleSubject
     */
    public void getAllProvince(HttpArrayObserver<AddressProvinceRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getAllProvince();
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }
    /**
     * 市的信息
     * @param observer
     * @param lifecycleSubject
     */
    public void getAllCityWithProvinceId(String provinceId,HttpArrayObserver<AddressCityRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getAllCityWithProvinceId(provinceId);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 区的信息
     * @param observer
     * @param lifecycleSubject
     */
    public void getAllDistrictWithCityId(String cityId, HttpArrayObserver<AddressDistrictRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getAllDistrictWithCityId(cityId);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 新增
     * @param map
     * @param observer
     * @param lifecycleSubject
     */
    public void addUserAddressInfo(Map<String,String> map, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().addUserAddressInfo(map);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }


    /**
     * 地址列表
     * @param userid
     * @param observer
     * @param lifecycleSubject
     */
    public void getUserAddressListInfo(String userid, HttpArrayObserver<AddressInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getUserAddressListInfo(userid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 删除
     * @param userid
     * @param id
     * @param observer
     * @param lifecycleSubject
     */
    public void deleteUserAddressInfo(String userid,String id, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().deleteUserAddressInfo(userid,id);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 默认
     * @param userid
     * @param addressid
     * @param observer
     * @param lifecycleSubject
     */
    public void updateUserDefaultAddress(String userid,String addressid, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().updateUserDefaultAddress(userid,addressid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 修改地址
     * @param map
     * @param observer
     * @param lifecycleSubject
     */
    public void editUserAddressInfo(Map<String,String> map, HttpObserver<String> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().editUserAddressInfo(map);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

}
