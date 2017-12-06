package com.zhongzi.taomanjia.presenter.address;

import android.content.Context;

import com.zhongzi.taomanjia.model.AddressModel;
import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfo;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfoEvent;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddAddressView;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1.
 * 地址，新增，修改
 */

public class AddAddressPresenter extends BasePresenter<IAddAddressView> {

    private static final String TAG = AddAddressPresenter.class.getSimpleName();
    private AddressModel mAddressModel;
    private LoginModel mLoginModel;

    private Map<String ,String> map=new HashMap<>();
    public AddAddressPresenter(IAddAddressView iAddAddressView) {
        super(iAddAddressView);
        mAddressModel = AddressModel.getInstance();
        mLoginModel=LoginModel.getInstance();
    }

    /**
     * 省
     */
    public void allProvince(){
        mAddressModel.getAllProvince(new HttpArrayObserver<AddressProvinceRes>() {

            @Override
            public void onNext(String title, List<AddressProvinceRes> t) {
                LogUtil.e("-------------------");
                mIView.allProvince(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
    /**
     * s市
     */
    public void allCity(String provinceId){
        mAddressModel.getAllCityWithProvinceId(provinceId,new HttpArrayObserver<AddressCityRes>() {
            @Override
            public void onNext(String title, List<AddressCityRes> t) {
                LogUtil.e(t.get(0).toString());
                mIView.allCity(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    /**
     * s区
     */
    public void allDistrict(String cityId){
        mAddressModel.getAllDistrictWithCityId(cityId,new HttpArrayObserver<AddressDistrictRes>() {
            @Override
            public void onNext(String title, List<AddressDistrictRes> t) {
                mIView.allDistrict(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    /**
     * 新增
     */
    public void addUserAddressInfo(Context c, AddressInfo info){
        Map<String ,String> map=getAddMap(c,info);
        if (map==null) return;
        mAddressModel.addUserAddressInfo(map, new HttpObserver<String>() {
            @Override
            public void onNext(String title, String s) {
                mIView.addSuccess(s);
            }

            @Override
            public void onError(int errType, String errMessage) {
                ToastUtil.show(errMessage);
            }
        },mIView.getLifeSubject());
    }

    /**
     *  修改
     * @param c
     * @param info
     */
    public void editUserAddressInfo(Context c, AddressInfoEvent info){
        Map<String ,String> map=getEditorMap(c,info);
        if (map==null) return;
        mAddressModel.editUserAddressInfo(map, new HttpObserver<String>() {
            @Override
            public void onNext(String title, String s) {
                mIView.addSuccess(s);
            }

            @Override
            public void onError(int errType, String errMessage) {
                ToastUtil.show(errMessage);
            }
        },mIView.getLifeSubject());
    }

    private Map<String,String> getEditorMap(Context c,AddressInfoEvent info) {
        map.clear();
        try {
            map.put("userid",mLoginModel.getUserId(c));
            map.put("id",info.getId());
            map.put("name",info.getName());
            map.put("province",info.getProvince());
            map.put("ctiy",info.getCtiy());

            map.put("district",info.getDistrict());
            map.put("detail",info.getDetail());
            map.put("phone",info.getPhone());
            map.put("default",info.getFlag());
        }catch (NullException e){
            ToastUtil.show(e.getMessage());
            return null;
        }
        LogUtil.e("---------------");
        return map;
    }

    private Map<String,String> getAddMap(Context c,AddressInfo info) {
        map.clear();
        try {
            map.put("userid",mLoginModel.getUserId(c));
//            map.put("id",info.getId());
            map.put("name",info.getName());
            map.put("province",info.getProvince());
            map.put("ctiy",info.getCtiy());

            map.put("district",info.getDistrict());
            map.put("detail",info.getDetail());
            map.put("phone",info.getPhone());
            map.put("default",info.getFlag());
        }catch (NullException e){
            ToastUtil.show(e.getMessage());
            return null;
        }
        LogUtil.e("---------------");
        return map;
    }

}
