package com.zhongzi.taomanjia.model.entity.res.main;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.baseadapter.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 * 首页的数据
 */

public class MainRes implements MultiItemEntity {

    public String mItemType;
    private List<String> testBanner=new ArrayList<>();
    private List<String> icon8List=new ArrayList<>();
    private List<String> scrollSwitcher=new ArrayList<>();
    private List<String> todayRecommended=new ArrayList<>();
    private List<String> newProduct=new ArrayList<>();
    private List<String> adSwitch=new ArrayList<>();
    private List<String> branDzone=new ArrayList<>();
    private List<String> choice=new ArrayList<>();
    private List<String> mayLike=new ArrayList<>();
//    private Map<String ,List<>>


    public List<String> getMayLike() {
        return mayLike;
    }

    public List<String> getChoice() {
        return choice;
    }

    public List<String> getAdSwitch() {
        return adSwitch;
    }

    public List<String> getBranDzone() {
        return branDzone;
    }

    public List<String> getTodayRecommended() {
        return todayRecommended;
    }

    public List<String> getTestBanner() {
        return testBanner;
    }

    public List<String> getIcon8List() {
        return icon8List;
    }

    public List<String> getScrollSwitcher() {
        return scrollSwitcher;
    }

    public MainRes(String itemType){
        this.mItemType=itemType;
        if (BaseConstants.topBanner.equals(itemType)){
            testBanner.clear();
            for (int i=0;i<5;i++){
                testBanner.add("aaaaa=="+i);
            }
        }else if (BaseConstants.iconList.equals(itemType)){
            icon8List.clear();
            for (int i=0;i<8;i++){
                icon8List.add("aaaaa=="+i);
            }
        }else if (BaseConstants.scrollSwitcher.equals(itemType)){
            scrollSwitcher.clear();
            for (int i=0;i<8;i++){
                scrollSwitcher.add("aaaaa=="+i);
            }
        }else if (BaseConstants.todayRecommended.equals(itemType)){
            todayRecommended.clear();
            for (int i=0;i<3;i++){
                todayRecommended.add("aaaaa=="+i);
            }
        }else if (BaseConstants.newProduct.equals(itemType)){
            newProduct.clear();
            for (int i=0;i<8;i++){
                newProduct.add("aaaaa=="+i);
            }
        }else if (BaseConstants.adSwitch.equals(itemType)){
            adSwitch.clear();
            for (int i=0;i<5;i++){
                adSwitch.add("aaaaa=="+i);
            }
        }else if (BaseConstants.branDzone.equals(itemType)){
            branDzone.clear();
            for (int i=0;i<15;i++){
                branDzone.add("aaaaa=="+i);
            }
        }else if (BaseConstants.choice.equals(itemType)){
            choice.clear();
            for (int i=0;i<8;i++){
                choice.add("aaaaa=="+i);
            }
        }else if (BaseConstants.mayLike.equals(itemType)){
            mayLike.clear();
            for (int i=0;i<18;i++){
                mayLike.add("aaaaa=="+i);
            }
        }
    }


    @Override
    public int getItemType() {
        if (BaseConstants.topBanner.equals(mItemType)){
            return BaseConstants.MAIN_TOP_BANNER;
        }else if (BaseConstants.iconList.equals(mItemType)){
            return BaseConstants.MAIN_8ICON_LIST;
        }else if (BaseConstants.scrollSwitcher.equals(mItemType)){
            return BaseConstants.MAIN_SCROLL_SWITCHER;
        }else if (BaseConstants.todayRecommended.equals(mItemType)){
            return BaseConstants.MAIN_TODAY_RECOMMENDED;
        }else if (BaseConstants.newProduct.equals(mItemType)){
            return BaseConstants.MAIN_NEW_PRODUCT;
        }else if (BaseConstants.adSwitch.equals(mItemType)){
            return BaseConstants.MAIN_AD_SWITCH;
        }else if (BaseConstants.branDzone.equals(mItemType)){
            return BaseConstants.MAIN_BRAND_ZONE;
        }else if (BaseConstants.choice.equals(mItemType)){
            return BaseConstants.MAIN_CHOICE;
        }else if (BaseConstants.titleMayLike.equals(mItemType)){
            return BaseConstants.MAIN_TITLE_MAY_LIKE;
        }else if (BaseConstants.mayLike.equals(mItemType)){
            return BaseConstants.MAIN_MAY_LIKE;
        }
        return BaseConstants.MAIN_MAY_LIKE;
    }


    public int getSpanSize() {
        if(BaseConstants.mayLike.equals(mItemType)){
            return 2;
        }
        return 4;
    }
}
