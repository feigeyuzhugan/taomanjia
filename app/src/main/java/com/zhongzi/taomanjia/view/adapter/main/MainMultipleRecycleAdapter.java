package com.zhongzi.taomanjia.view.adapter.main;

import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.main.MainRes;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.autoscrollviewpager.BGABanner;
import com.zhongzi.taomanjia.view.widget.baseadapter.BaseMultiItemQuickAdapter;
import com.zhongzi.taomanjia.view.widget.baseadapter.BaseQuickAdapter;
import com.zhongzi.taomanjia.view.widget.baseadapter.BaseViewHolder;
import com.zhongzi.taomanjia.view.widget.view_switcher.UpDownViewSwitcher;

/**
 * Created by Administrator on 2017/12/20.
 * 首页的adapter
 */

public class MainMultipleRecycleAdapter extends BaseMultiItemQuickAdapter<MainRes, BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup, BaseQuickAdapter.OnItemChildClickListener {
    Uri str = Uri.parse("https://m.360buyimg.com/mobilecms/s720x322_jfs/t4903/41/12296166/85214/15205dd6/58d92373N127109d8.jpg!q70.jpg");
    private int maxHasLoadPosition;

    /**
     * 当前position监听
     */
    private MainPositionChangedListener listener;

    public void setListener(MainPositionChangedListener listener) {
        this.listener = listener;
    }

    public void resetMaxHasLoadPosition() {
        maxHasLoadPosition = 0;
    }

    public MainMultipleRecycleAdapter() {
        setSpanSizeLookup(this);
        addItemType(BaseConstants.MAIN_TOP_BANNER, R.layout.item_main_top_banner);//最顶部广告轮播
        addItemType(BaseConstants.MAIN_8ICON_LIST, R.layout.item_main_8icon_list);//最顶部广告轮播下8个icon
        addItemType(BaseConstants.MAIN_SCROLL_SWITCHER, R.layout.item_main_scroll_switcher);//滚动消息
        addItemType(BaseConstants.MAIN_TODAY_RECOMMENDED, R.layout.item_main_today_recommended);//今日推荐
        addItemType(BaseConstants.MAIN_NEW_PRODUCT, R.layout.item_main_new_product);//新品展示
        addItemType(BaseConstants.MAIN_AD_SWITCH, R.layout.item_main_middle_banner);//广告切换
        addItemType(BaseConstants.MAIN_BRAND_ZONE, R.layout.item_main_brand_zone);//品牌专区
        addItemType(BaseConstants.MAIN_CHOICE, R.layout.item_main_choice);//淘满家精选
        addItemType(BaseConstants.MAIN_TITLE_MAY_LIKE, R.layout.item_main_may_like_title);//你可能喜欢的头
        addItemType(BaseConstants.MAIN_MAY_LIKE, R.layout.item_main_may_like);//淘满家精选
    }


    @Override
    public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        return false;
    }

    @Override
    protected void convert(BaseViewHolder helper, MainRes item, int position) {
        if (listener != null) {
            listener.currentPosition(position);
        }
        if (maxHasLoadPosition < position) {
            maxHasLoadPosition = position;
        }
        LogUtil.e("-----------测试------------------" + item.mItemType);
        if ("topBanner".equals(item.mItemType) && maxHasLoadPosition <= position) {
            LogUtil.e("-----------测试------------------" + position);
            bindTopBannerData(helper, item, position);//最上面的界面轮播
        } else if ("iconList".equals(item.mItemType) && maxHasLoadPosition <= position) {
            LogUtil.e("-----------测试------------------" + position);
            bindIconListData(helper, item, position);//最上8个icon
        }else if (BaseConstants.scrollSwitcher.equals(item.mItemType)&& maxHasLoadPosition <= position){
            bindScrollSwitcherData(helper, item, position);//红包滚动
        }else if (BaseConstants.todayRecommended.equals(item.mItemType)){
            bindTodayRecommendedData(helper, item, position);//今日推荐
        }else if (BaseConstants.newProduct.equals(item.mItemType)){
            bindNewProductData(helper, item, position);//新品
        }else if (BaseConstants.adSwitch.equals(item.mItemType)){
            bindAdSwitchData(helper, item, position);//广告切换
        } else if (BaseConstants.branDzone.equals(item.mItemType)){
            bindBranDzoneData(helper, item, position);//品牌专区
        } else if (BaseConstants.choice.equals(item.mItemType)){
            bindChoiceData(helper, item, position);//淘满家精选
        }else if (BaseConstants.titleMayLike.equals(item.mItemType)){
            bindTitleMayLikeData(helper, item, position);//你可能喜欢
        }else if (BaseConstants.mayLike.equals(item.mItemType)){
            bindMayLikeData(helper, item, position);//你可能喜欢
        }
    }

    /**
     * 你可能喜欢的头
     * @param helper
     * @param item
     * @param position
     */
    private void bindTitleMayLikeData(BaseViewHolder helper, MainRes item, int position) {

    }

    /**
     * 可能喜欢
     * @param helper
     * @param item
     * @param position
     */
    private void bindMayLikeData(BaseViewHolder helper, MainRes item, int position) {
        LogUtil.e(item.getMayLike().size());
        ((SimpleDraweeView)helper.getView(R.id.item_may_like_img)).setImageURI(str);
    }

    /**
     * 淘满家精选
     * @param helper
     * @param item
     * @param position
     */
    private void bindChoiceData(BaseViewHolder helper, MainRes item, int position) {
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_1)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_2)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_3)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_4)).setImageURI(str);

        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_5)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_6)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_7)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_choice_8)).setImageURI(str);
    }

    /**
     * 广告切换
     * @param helper
     * @param item
     * @param position
     */
    private void bindAdSwitchData(BaseViewHolder helper, final MainRes item, int position) {
        BGABanner banner = helper.getView(R.id.item_main_middle_banner_item);
        LogUtil.e(item.getAdSwitch().size());
        banner.setDelegate(new BGABanner.Delegate<View, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, String model, int position) {
                Toast.makeText(itemView.getContext(), "测试" + item.getAdSwitch().get(position), Toast.LENGTH_SHORT).show();
            }
        });
        banner.setAdapter(new BGABanner.Adapter<View, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, String model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_main_banner_content);
                simpleDraweeView.setImageURI("https://m.360buyimg.com/mobilecms/s720x322_jfs/t4903/41/12296166/85214/15205dd6/58d92373N127109d8.jpg!q70.jpg");
            }
        });
        banner.setData(R.layout.item_main_top_banner_img, item.getAdSwitch(), null);
    }

    /**
     * 品牌专区
     * @param helper
     * @param item
     * @param position
     */
    private void bindBranDzoneData(BaseViewHolder helper, MainRes item, int position) {
        if (item.getBranDzone() == null || item.getBranDzone().size() <= 0) return;

        LogUtil.e(item.getBranDzone().size());
        RecyclerView recycleview=helper.getView(R.id.item_main_brand_zone_recyclerview);
        GridLayoutManager manager=new GridLayoutManager(mContext,5, GridLayoutManager.VERTICAL,false);
        recycleview.setLayoutManager(manager);
        BrandDzoneAdapter mBrandDzoneAdapter=new BrandDzoneAdapter(R.layout.item_main_brand_zone_img,item.getBranDzone());
        recycleview.setAdapter(mBrandDzoneAdapter);
    }

    /**
     * 新品展示
     * @param helper
     * @param item
     * @param position
     */
    private void bindNewProductData(BaseViewHolder helper, MainRes item, int position) {
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_1)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_2)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_3)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_4)).setImageURI(str);

        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_5)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_6)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_7)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.item_main_newproduct_img_8)).setImageURI(str);

    }

    /**
     * 今日推荐
     * @param helper
     * @param item
     * @param position
     */
    private void bindTodayRecommendedData(BaseViewHolder helper, MainRes item, int position) {
        LogUtil.e("------------"+item.getTodayRecommended().size());
        ((SimpleDraweeView)helper.getView(R.id.today_recommend_img_1)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.today_recommend_img_2)).setImageURI(str);
        ((SimpleDraweeView)helper.getView(R.id.today_recommend_img_3)).setImageURI(str);
    }

    /**
     * 滚动红包消息
     * @param helper
     * @param item
     * @param position
     */
    private void bindScrollSwitcherData(BaseViewHolder helper, final MainRes item, int position) {
        UpDownViewSwitcher viewSwitcher = helper.getView(R.id.item_main_switcher_up);
        viewSwitcher.setSwitcheNextViewListener(new UpDownViewSwitcher.SwitchNextViewListener() {
            @Override
            public void switchTONextView(View nextView, int index) {
                if (nextView==null) return;
                TextView title= (TextView) nextView.findViewById(R.id.switcher_textview);
                title.setText(item.getScrollSwitcher().get(index % item.getScrollSwitcher().size()));
            }
        });
        viewSwitcher.setContentLayout(R.layout.item_main_scroll_switcher_item);
    }

    /**
     * 8个图标
     *
     * @param helper
     * @param item
     * @param position
     */
    private void bindIconListData(BaseViewHolder helper, MainRes item, int position) {
        if (helper == null) {
            LogUtil.e("------------");
            return;
        }
        LogUtil.e("------------"+item.getIcon8List().size());
//        if (item.getIcon8List().size()==8){
            /*helper.getView(R.id.item_main_icon_1);
            helper.getView(R.id.item_main_icon_2);
            helper.getView(R.id.item_main_icon_3);
            helper.getView(R.id.item_main_icon_4);

            helper.getView(R.id.item_main_icon_5);
            helper.getView(R.id.item_main_icon_6);
            helper.getView(R.id.item_main_icon_7);
            helper.getView(R.id.item_main_icon_8);*/
            LogUtil.e("------------"+item.getIcon8List().get(position));
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_1)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_2)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_3)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_4)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_5)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_6)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_7)).setImageURI(str);
            ((SimpleDraweeView)helper.getView(R.id.item_main_icon_8)).setImageURI(str);
//        }
    }

    /**
     * 绑定上面的banner
     *
     * @param helper
     * @param item
     * @param position
     */
    private void bindTopBannerData(BaseViewHolder helper, final MainRes item, int position) {
        BGABanner banner = helper.getView(R.id.item_main_banner);
        banner.setDelegate(new BGABanner.Delegate<View, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, String model, int position) {
                Toast.makeText(itemView.getContext(), "测试" + item.getTestBanner().get(position), Toast.LENGTH_SHORT).show();
            }
        });
        banner.setAdapter(new BGABanner.Adapter<View, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, String model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.item_main_banner_content);
                simpleDraweeView.setImageURI("https://m.360buyimg.com/mobilecms/s720x322_jfs/t4903/41/12296166/85214/15205dd6/58d92373N127109d8.jpg!q70.jpg");
            }
        });
        banner.setData(R.layout.item_main_top_banner_img, item.getTestBanner(), null);
    }

    /**
     * 计算
     *
     * @param gridLayoutManager
     * @param position
     * @return
     */
    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return mData.get(position).getSpanSize();
    }
}
