package com.zhongzi.taomanjia.view.adapter.order;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhongzi.taomanjia.view.fragment.order.OrderFragment;

/**
 * Created by Administrator on 2017/12/18.
 *  订单信息
 */

public class OrderPagerAdapter extends FragmentStatePagerAdapter {

    private String[] strs={"待付款","待发货","待发货","待评价","退换/退款"};

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return OrderFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return strs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strs[position];
    }
}
