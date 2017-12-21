package com.zhongzi.taomanjia.view.widget.baseadapter.loadmore;


import com.zhongzi.taomanjia.R;

/**
 * Created by BlingBling on 2016/10/11.
 */

public final class SimpleLoadMoreView extends LoadMoreView {

    @Override public int getLayoutId() {
        return R.layout.lib_quick_view_load_more;
    }

    @Override protected int getLoadingViewId() {
        return R.id.lib_quick_load_more_loading_view;
    }

    @Override protected int getLoadFailViewId() {
        return R.id.lib_quick_load_more_load_fail_view;
    }

    @Override protected int getLoadEndViewId() {
        return R.id.lib_quick_load_more_load_end_view;
    }
}
