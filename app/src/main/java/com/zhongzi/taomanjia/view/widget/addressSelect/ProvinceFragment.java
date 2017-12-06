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
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class ProvinceFragment implements AdapterView.OnItemClickListener {
//    private SelectAddresList mSelectAddresList;
    private AddressCallBack callBack;
    private String code;
    private Context context;
    private AddressAdapter adapter;
    private ListView listview;
    private List<AddressProvinceRes> mList=new ArrayList<>();

    public void setList(List<AddressProvinceRes> list) {
        mList.clear();
        this.mList = list;
        adapter.notifyDataSetChanged();
    }

    public ProvinceFragment(Context context, AddressCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        initView();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ListView getListview() {
        return listview;
    }

    public View initView() {
        listview = (ListView) LayoutInflater.from(context).inflate(R.layout.popup_address_listview, null);
//        list.clear();
//        list=mSelectAddresList.allProvinceRes();
        adapter = new AddressAdapter();
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        return listview;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        code = mList.get(i).getProvinceID();
        if (callBack != null) {
            callBack.selectProvince(mList.get(i));
        }
        adapter.notifyDataSetChanged();
    }

    class AddressAdapter extends BaseAdapter {


        public AddressAdapter() {
        }

        @Override
        public int getCount() {
            if (mList != null) {
                return mList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return mList.get(i);
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
            text.setText(mList.get(i).getProvinceName());
            if (mList.get(i).getProvinceID().equals(code)) {
                text.setTextColor(context.getResources().getColor(R.color.red));
                ivSelect.setVisibility(View.VISIBLE);
            }
            return view;
        }
    }
}
