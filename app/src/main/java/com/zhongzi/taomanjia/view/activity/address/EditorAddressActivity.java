package com.zhongzi.taomanjia.view.activity.address;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfo;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfoEvent;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.presenter.address.AddAddressPresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddAddressView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.widget.addressSelect.SelectAddresFinish;
import com.zhongzi.taomanjia.view.widget.addressSelect.SelectAddresList;
import com.zhongzi.taomanjia.view.widget.addressSelect.SelectAddressPop;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/5.
 * 修改地址
 */

public class EditorAddressActivity extends ToolbarBaseActivity implements SelectAddresFinish,IAddAddressView,SelectAddresList {
    @BindView(R.id.address_add_username)
    EditText addressAddUsername;
    @BindView(R.id.address_add_userphone)
    EditText addressAddUserphone;
    @BindView(R.id.address_add_user_region)
    TextView addressAddUserRegion;
    @BindView(R.id.address_add_user_region_rl)
    LinearLayout addressAddUserRegionRl;
    @BindView(R.id.address_add_details_address)
    EditText addressAddDetailsAddress;
    @BindView(R.id.address_add_default)
    ImageView addressAddDefault;
    @BindView(R.id.address_add_ok)
    Button addressAddOk;

    private SelectAddressPop dialog;//
    private AddAddressPresenter mPresenter;
    private AddressProvinceRes mAddressProvinceRes;//省
    private AddressCityRes mAddressCityRes;//市
    private AddressDistrictRes mAddressDistrictRes;//区
    private AddressInfoEvent info;//

    private String id;
    private String name;
    private String province;
    private String ctiy;

    private String district;
    private String detail;
    private String phone;
    private String flag="0";
    int i=0;
    private List<AddressProvinceRes> mProvinceResList=new ArrayList<>();
    private List<AddressCityRes> mCityResList=new ArrayList<>();
    private List<AddressDistrictRes> mDistrictResList=new ArrayList<>();
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_address_add);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("新增地址");
        mPresenter=new AddAddressPresenter(this);
        mAddressProvinceRes=new AddressProvinceRes();
        mAddressCityRes=new AddressCityRes();
        mAddressDistrictRes=new AddressDistrictRes();
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
    }


    @OnClick({R.id.address_add_user_region_rl, R.id.address_add_default, R.id.address_add_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.address_add_user_region_rl:
                show();
                break;
            case R.id.address_add_default:
                if ((i%2)==0){
                    addressAddDefault.setImageDrawable(getResourceDrawable(R.drawable.address_default_off));
                    flag=0+"";
                }else {
                    addressAddDefault.setImageDrawable(getResourceDrawable(R.drawable.address_default_on));
                    flag=1+"";

                }
                i++;
                break;
            case R.id.address_add_ok:
//                mPresenter.addUserAddressInfo(this);
                setInitView();
                info=new AddressInfoEvent(name,province, ctiy,district,detail,phone,flag,id);
                mPresenter.editUserAddressInfo(info);
                break;
        }
    }

    /**
     * 展示一个dialog
     */
    private void show() {

        dialog = new SelectAddressPop();
        dialog.setSelectAddresList(this);
        dialog.setSelectAddresFinish(this);
//        dialog.setAddress(provinceCode,cityCode,areaCode);
        dialog.show(getSupportFragmentManager(), "address");
        mPresenter.allProvince();
//            dialog.setOnAddressSelectedListener(this);
//            dialog.setDialogDismisListener(this);
//            dialog.setTextSize(14);//设置字体的大小
//            dialog.setIndicatorBackgroundColor(android.R.color.holo_orange_light);//设置指示器的颜色
//            dialog.setTextSelectedColor(android.R.color.holo_orange_light);//设置字体获得焦点的颜色
//            dialog.setTextUnSelectedColor(android.R.color.holo_blue_light);//设置字体没有获得焦点的颜色
////            dialog.setDisplaySelectorArea("31",1,"2704",1,"2711",0,"15582",1);//设置已选中的地区
//            dialog.setSelectorAreaPositionListener(this);
//            dialog.show();
//        }
    }

    @Override
    public void finish(AddressProvinceRes province, AddressCityRes city, AddressDistrictRes area) {
        LogUtil.e(province.toString()+"-"+city.toString()+"="+area.toString());
        String address=province.getProvinceName()+" "+city.getCityName()+" "+area.getDistrictName();
        LogUtil.e(address);
        addressAddUserRegion.setText(address);
        mAddressProvinceRes=province;
        mAddressCityRes=city;
        mAddressDistrictRes=area;
    }


    @Override
    public void allProvince(List<AddressProvinceRes> list) {
//        LogUtil.e("-----------------");
        mProvinceResList.clear();
        mProvinceResList.addAll(list);
        dialog.setProvinceList(list);
    }

    @Override
    public void allCity(List<AddressCityRes> list) {
        LogUtil.e(list.get(0).toString());
        mCityResList.clear();
        mCityResList.addAll(list);
        dialog.setCityList(list);
    }

    @Override
    public void allDistrict(List<AddressDistrictRes> list) {
        mDistrictResList.clear();
        mDistrictResList.addAll(list);
        dialog.setDistrictsList(list);
    }

    @Override
    public void addSuccess(String mes) {
        ToastUtil.show(mes);
//        finish();
        UiUtils.startActivity(this, BaseConstants.MY_ADDRESS,BaseConstants.CHECK_NOT_LOGIN);
        finish();

    }


    /**
     *
     */
    private void setInitView() {
        name=addressAddUsername.getText().toString().trim();
        if (province==null){
            province=mAddressProvinceRes.getProvinceID();
            ctiy=mAddressCityRes.getCityID();
            district=mAddressDistrictRes.getDistrictID();
        }
        detail=addressAddDetailsAddress.getText().toString().trim();
        phone=addressAddUserphone.getText().toString().trim();
//        flag=i+"";
    }


    @Override
    public void allCity(String provinceId) {
        mPresenter.allCity(provinceId);
    }

    @Override
    public void addDistrict(String cityId) {
        mPresenter.allDistrict(cityId);
    }

    @Override
    protected void onStop() {

        super.onStop();
        EventBusUtil.postEvent(new AddressEvent(BaseConstants.ADDRESS_ADD_TO_USER));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AddressInfoEvent event){
        setAddressInfoView(event);
    }

    /**
     * 设置传递过来的数据
     * @param event
     */
    private void setAddressInfoView(AddressInfoEvent event) {
        addressAddUsername.setText(event.getName());
        if (event.getFlag().equals("0")){
            addressAddDefault.setImageDrawable(getResourceDrawable(R.drawable.address_default_off));
        }else {
            addressAddDefault.setImageDrawable(getResourceDrawable(R.drawable.address_default_on));

        }
        flag=event.getFlag();
        addressAddUserphone.setText(event.getPhone());
        addressAddDetailsAddress.setText(event.getDetail());
        province=event.getProvince();
        ctiy=event.getCtiy();
        district=event.getDistrict();
        id=event.getId();
//        mPresenter.allProvince();
//        mPresenter.allCity(event.getProvince());
//        mPresenter.allDistrict(event.getCtiy());
//        String address=m
    }


}
