package com.zhongzi.taomanjia.view.widget.addressSelect;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */

public class AddressListAdapter extends PagerAdapter {
    private List<View> views;

    public AddressListAdapter( List<View> views) {
        this.views = views;
    }
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        return views.get(arg1);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}