package com.zhongzi.taomanjia.view.adapter.product;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhongzi.taomanjia.model.ProductTypeModel;
import com.zhongzi.taomanjia.view.fragment.ProductItemFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 *
 */

public class ProductAdapter extends FragmentStatePagerAdapter{
    private List<String> titles;
    //, List<String> list
    public ProductAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.titles= list;
    }

    @Override
    public Fragment getItem(int position) {
        return ProductItemFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
