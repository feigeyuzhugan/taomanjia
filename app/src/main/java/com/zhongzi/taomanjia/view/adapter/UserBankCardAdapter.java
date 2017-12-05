package com.zhongzi.taomanjia.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zhongzi.taomanjia.view.fragment.bankcard.BankcardFragmnet;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/29.
 */

public class UserBankCardAdapter extends FragmentPagerAdapter {
    private String[] arr={"全  部","待审核","已通过","已驳回"};

    public UserBankCardAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BankcardFragmnet.newInstance(position);
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }


}
