package com.zhongzi.taomanjia.view.adapter.main;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.DensityUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.baseadapter.BaseQuickAdapter;
import com.zhongzi.taomanjia.view.widget.baseadapter.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 * 品牌专区
 */

public class BrandDzoneAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    Uri str = Uri.parse("https://m.360buyimg.com/mobilecms/s720x322_jfs/t4903/41/12296166/85214/15205dd6/58d92373N127109d8.jpg!q70.jpg");
    public BrandDzoneAdapter(int layoutResId, List<String> data){
        super(layoutResId,data);
        LogUtil.e(data.size());
    }

    @Override
    protected void convert(BaseViewHolder helper, String item, int position) {
        ((SimpleDraweeView)helper.getView(R.id.item_main_brand_zone_img_item)).setImageURI(str);
    }

    /**
     *
     * @param layoutResId ID for an XML layout resource to load
     * @param parent      Optional view to be the parent of the generated hierarchy or else simply an object that
     *                    provides a set of LayoutParams values for root of the returned
     *                    hierarchy
     * @return
     */
/*    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_main_brand_zone_img,null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (0.286 * DensityUtil.getScreenWidth(mContext)), LinearLayout.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return view;
    }*/
}
