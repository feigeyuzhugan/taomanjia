package com.zhongzi.taomanjia.view.widget.addressSelect;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.utils.DensityUtil;
import com.zhongzi.taomanjia.utils.StringUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class SelectAddressPop extends DialogFragment implements AddressCallBack{
    private SelectAddresFinish mSelectAddresFinish;
    private Context context;
    private View view;
    private ViewPager viewPager;
    private PagerSlidingTabStrip pagerTab;
    private FrameLayout popBg;

    private AddressProvinceRes province;
    private AddressCityRes city ;
    private AddressDistrictRes district;
    private String defutText;
    private ProvinceFragment mProvinceFragment;
    private CityFragment mCityFragment;
    private DistrictFragment mDistrictFragment;
    private SelectAddresList mSelectAddresList;

    public void setSelectAddresList(SelectAddresList selectAddresList) {
        this.mSelectAddresList = selectAddresList;
    }

    public void setSelectAddresFinish(SelectAddresFinish mSelectAddresFinish) {
        this.mSelectAddresFinish = mSelectAddresFinish;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        context = getActivity();
        initView();
        Dialog dialog = new Dialog(context, R.style.address_CustomDatePickerDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);

        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        return dialog;
    }

    public void setAddress(String pCode, String cCode, String aCode){
        if (StringUtils.isNoEmpty(pCode) && StringUtils.isNoEmpty(cCode) && StringUtils.isNoEmpty(aCode)){
//            province = AddressManager.newInstance().findProvinceByCode(pCode);
//            city = province.findCityByCode(cCode);
//            district = city.findDistrictByCode(aCode);
        }
    }

    private void initView() {
        view = LayoutInflater.from(context).inflate(R.layout.popup_address,null);
        ImageView ivClose = (ImageView) view.findViewById(R.id.pop_address_ivclose);
        viewPager = (ViewPager) view.findViewById(R.id.pop_address_viewPager);
        pagerTab = (PagerSlidingTabStrip) view.findViewById(R.id.pop_address_pagertab);
        popBg = (FrameLayout)view.findViewById(R.id.pop_address_bg);
        defutText = context.getString(R.string.selset_address);
        pagerTab.setTextSize(DensityUtil.sp2px(context, 14));
        pagerTab.setSelectedColor(getResources().getColor(R.color.red));
        pagerTab.setTextColor(getResources().getColor(R.color.black_4d));

        List<View> lis = new ArrayList<View>();
        mProvinceFragment = new ProvinceFragment(context,this);
        mCityFragment = new CityFragment(context,this);
        mDistrictFragment = new DistrictFragment(context,this);
        lis.add(mProvinceFragment.getListview());
        lis.add(mCityFragment.getListview());
        lis.add(mDistrictFragment.getListview());
        viewPager.setAdapter(new AddressListAdapter(lis));

        String[] addres = null;
        if (province != null && city != null && district != null){
            addres = new String[]{province.getProvinceName(),city.getCityName(),district.getDistrictName()};
            mProvinceFragment.setCode(province.getProvinceID());
//            mCityFragment.setCode(province.getCode(),city.getCode());
//            mDistrictFragment.setCode(province.getCode(),city.getCode(),district.getCode());
            viewPager.setCurrentItem(2);
            pagerTab.setTabsText(addres);
            pagerTab.setCurrentPosition(2);
        }else{
            addres = new String[]{defutText};
            viewPager.setCurrentItem(0);
            pagerTab.setTabsText(addres);
            pagerTab.setCurrentPosition(0);
        }
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        popBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        pagerTab.setTabOnClickListener(new TabOnClickListener() {
            @Override
            public void onClick(View tab, int position) {
                if (defutText.equals(pagerTab.getTabs()[position])){
                    return;
                }
                viewPager.setCurrentItem(position);
                String[] addres = null;
                switch (position){
                    case 0:
                        if (district != null) {
                            addres = new String[]{province.getProvinceName(), city.getCityName(),district.getDistrictName()};
                        }else if(city != null) {
                            addres = new String[]{province.getProvinceName(), city.getCityName(), defutText};
                        }else{
                            addres = new String[]{province.getProvinceName(), defutText};
                        }
                        break;
                    case 1:
                        if (district != null) {
                            addres = new String[]{province.getProvinceName(), city.getCityName(),district.getDistrictName()};
                        }else {
                            addres = new String[]{province.getProvinceName(), city.getCityName(), defutText};
                        }
                        //mDistrictFragment.resetIndex();
                        break;
                    case 2:
                        addres = new String[]{province.getProvinceName(),city.getCityName(),district.getDistrictName()};
                        break;
                }
                pagerTab.setTabsText(addres);
                pagerTab.setCurrentPosition(position);
            }
        });

    }

    @Override
    public void show(FragmentManager manager, String tag) {
        //KeyBoardUtils.closeKeybord((Activity) context);
        super.show(manager, tag);
    }

    @Override
    public void selectProvince(AddressProvinceRes province) {
        String[] addres = new String[]{province.getProvinceName(),defutText};
        pagerTab.setTabsText(addres);
        pagerTab.setCurrentPosition(1);
        viewPager.setCurrentItem(1);
        if(province != this.province){
            city = null;
            district = null;
        }
        this.province = province;
        mSelectAddresList.allCity(province.getProvinceID());
//        mCityFragment.setCode(province.getProvinceID(),null);
    }

    @Override
    public void selectCity(AddressCityRes city) {
        String[] addres = new String[]{province.getProvinceName(),city.getCityName(),defutText};
        pagerTab.setTabsText(addres);
        pagerTab.setCurrentPosition(2);
        viewPager.setCurrentItem(2);
        if(city != this.city){
            district = null;
        }
        this.city = city;
//        mDistrictFragment.setCode(province.getProvinceID(),city.getCityID(),null);
        mSelectAddresList.addDistrict(city.getCityID());
    }

    @Override
    public void selectDistrict(AddressDistrictRes district) {
        String[] addres = new String[]{province.getProvinceName(),city.getCityName(),district.getDistrictName()};
        pagerTab.setTabsText(addres);
        this.district = district;
        mSelectAddresFinish.finish(province,city,district);
        dismiss();
    }

    /**
     * 设置省
     * @param list
     */
    public void setProvinceList(List<AddressProvinceRes> list){
        LogUtil.e("参数省-----"+list.get(0).toString());
        mProvinceFragment.setList(list);
    }

    /**
     * 设置市
     * @param list
     */
    public void setCityList(List<AddressCityRes> list){
        mCityFragment.setCityList(list);
    }

    /**
     * 设置区
     * @param list
     */
    public void setDistrictsList(List<AddressDistrictRes> list){
        mDistrictFragment.setDistrictsList(list);
    }
}
