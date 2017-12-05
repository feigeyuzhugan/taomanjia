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
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class DistrictFragment implements AdapterView.OnItemClickListener{
    private AddressCallBack callBack;
    private String code ;
    private Context context;
    private AddressAdapter adapter;
    private ListView listview;
    private String provinceCode ;
    private String cityCode;
    private List<AddressDistrictRes> mDistrictsList = new ArrayList<AddressDistrictRes>();


    public void setDistrictsList(List<AddressDistrictRes> districtsList) {
        mDistrictsList.clear();
        this.mDistrictsList = districtsList;
        adapter.notifyDataSetChanged();
    }

    public DistrictFragment(Context context, AddressCallBack callBack){
        this.context = context;
        this.callBack = callBack;
        initView();
    }
/*    public void setCode(String provinceCode,String cityCode,String code){
        if (!provinceCode.equals(this.provinceCode) || !cityCode.equals(this.cityCode)){
            this.code = null;
        }
        if (StringUtils.isNoEmpty(code)){
            this.code = code;
        }
        this.cityCode = cityCode;
        this.provinceCode = provinceCode;
        mDistrictsList.clear();
//        districtsList.addAll(AddressManager.newInstance().findProvinceByCode(provinceCode)
//                .findCityByCode(cityCode).getAllDistricts());
        adapter.notifyDataSetChanged();
    }*/

    public ListView getListview() {
        return listview;
    }

    public View initView() {
        listview = (ListView) LayoutInflater.from(context).inflate(R.layout.popup_address_listview,null);
        //districtsList = AddressManager.newInstance().findProvinceByCode(provinceCode).findCityByCode(cityCode).getAllDistricts();
        adapter = new AddressAdapter();
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        return listview;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        code = mDistrictsList.get(i).getDistrictID();
        if (callBack != null){
            callBack.selectDistrict(mDistrictsList.get(i));
        }
        adapter.notifyDataSetChanged();
    }

    class AddressAdapter extends BaseAdapter {

//        private List<AddressDistrictRes> list;
//
//        public AddressAdapter(List<AddressDistrictRes> list){
//            this.list = list;
//        }

        @Override
        public int getCount() {
            if (mDistrictsList != null) {
                return mDistrictsList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return mDistrictsList.get(i);
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
            text.setText(mDistrictsList.get(i).getDistrictName());
            if (mDistrictsList.get(i).getDistrictID().equals(code)) {
                text.setTextColor(context.getResources().getColor(R.color.red));
                ivSelect.setVisibility(View.VISIBLE);
            }
            return view;
        }
    }
}