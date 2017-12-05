package com.zhongzi.taomanjia.view.widget.addressSelect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.utils.StringUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class CityFragment implements AdapterView.OnItemClickListener{
    private AddressCallBack callBack;
    private String code;
    private Context context;
    private AddressAdapter adapter;
    private ListView listview;
    private String provinceCode ;
    private List<AddressCityRes> cityList = new ArrayList<AddressCityRes>();

    public void setCityList(List<AddressCityRes> list) {
        cityList.clear();
        this.cityList = list;
        LogUtil.e(cityList.get(0).toString());
        adapter.notifyDataSetChanged();
    }

    public CityFragment(Context context, AddressCallBack callBack){
        this.context = context;
        this.callBack = callBack;
        initView();
    }
/*    public void setCode(String provinceCode,String code){
        if (!provinceCode.equals(this.provinceCode)){
            this.code = null;
        }
        if (StringUtils.isNoEmpty(code)){
            this.code = code;
        }
        this.provinceCode = provinceCode;
        cityList.clear();
//        cityList.addAll(AddressManager.newInstance().findProvinceByCode(provinceCode).getAllCities());
        adapter.notifyDataSetChanged();
    }*/
    public ListView getListview() {
        return listview;
    }

    public View initView() {
        listview = (ListView) LayoutInflater.from(context).inflate(R.layout.popup_address_listview,null);
        //cityList = AddressManager.newInstance().findProvinceByCode(provinceCode).getAllCities();
//        adapter = new AddressAdapter(cityList);
        adapter = new AddressAdapter();
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        return listview;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        code = cityList.get(i).getCityID();
        if (callBack != null){
            callBack.selectCity(cityList.get(i));
        }
        adapter.notifyDataSetChanged();
    }

    class AddressAdapter extends BaseAdapter {

//        private List<AddressCityRes> list;
//
//        public AddressAdapter(List<AddressCityRes> list){
//            this.list = list;
//        }

        @Override
        public int getCount() {
            if (cityList != null) {
                return cityList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return cityList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.popup_address_listview_item_textview, null);
            TextView text = (TextView) view.findViewById(R.id.tvTextName);
            ImageView ivSelect = (ImageView) view.findViewById(R.id.ivSelect);
            text.setText(cityList.get(i).getCityName());
            if (cityList.get(i).getCityID().equals(code)) {
                text.setTextColor(context.getResources().getColor(R.color.red));
                ivSelect.setVisibility(View.VISIBLE);
            }
            return view;
        }
    }
}
