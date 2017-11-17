package com.zhongzi.taomanjia.view.activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
//import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.BaseActivity;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.fragment.MainFragment;
import com.zhongzi.taomanjia.view.fragment.ProductFragment;
import com.zhongzi.taomanjia.view.fragment.ShoppingFragment;
import com.zhongzi.taomanjia.view.fragment.UserFragment;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{
    BottomNavigationBar bottomNavigationView;
    private MainFragment mainFragment;//主页
    private ProductFragment productFragment;//分类
    private ShoppingFragment shoppingFragment;//购物车
    private UserFragment userFragment;//个人中心
    private BaseFragment mCurrentFragment;//基类
    private final static int MAIN=0;
    private final static int PRODUCT=1;
    private final static int SHOPPING=2;
    private final static int USER=3;
    private BadgeItem badgeItem;

   private void addMenuItem(){
       bottomNavigationView.setMode(BottomNavigationBar.MODE_FIXED)
               .setActiveColor(R.color.white)
               .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
               .addItem(new BottomNavigationItem(R.drawable.selector_menu_main,"首页"))
               .addItem(new BottomNavigationItem(R.drawable.selector_menu_product,"分类"))
               .addItem(new BottomNavigationItem(R.drawable.selector_menu_shopping,"购物车").setBadgeItem(badgeItem))
               .addItem(new BottomNavigationItem(R.drawable.selector_menu_user,"我的"))
               .setFirstSelectedPosition(0)
               .initialise();
//       bottomNavigationView.;
   }

    private void setDefaultFrament(){

        if (null==mainFragment){
            mainFragment= MainFragment.newInstance();
        }
        if (!mainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_content,mainFragment).commit();
            mCurrentFragment=mainFragment;
            mCurrentFragment.setUserVisibleHint(true);
        }
    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case MAIN:
                if (null==mainFragment){
                    mainFragment=MainFragment.newInstance();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), mainFragment);
                break;
            case PRODUCT:
                if (null==productFragment){
                    productFragment=ProductFragment.newInstance();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), productFragment);
                break;
            case SHOPPING:
                if (null==shoppingFragment){
                    shoppingFragment=ShoppingFragment.newInstance();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), shoppingFragment);
                break;
            case USER:
                if (null==userFragment){
                    userFragment=UserFragment.newInstance();
                }
                addOrShowFragment(getSupportFragmentManager().beginTransaction(), userFragment);
                break;
        }
    }

    private void addOrShowFragment(FragmentTransaction transaction, BaseFragment fragment) {
        if (mCurrentFragment == fragment) return;

        if (!fragment.isAdded()) {
            transaction.hide(mCurrentFragment).add(R.id.main_content, fragment).commit();
        } else {
            transaction.hide(mCurrentFragment).show(fragment).commit();
        }

        //不与ViewPager嵌套的话，需要显式调用setUserVisibleHint
        mCurrentFragment.setUserVisibleHint(false);
        mCurrentFragment = fragment;
        mCurrentFragment.setUserVisibleHint(true);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_main_v2);
    }

    @Override
    protected void initView() {
        badgeItem=new BadgeItem()
                .setText("999")
                .setBorderWidth(2)//Badge的Border(边界)宽度
                .setTextColor(Color.RED)
                .setBorderColor(Color.RED)//Badge的Border颜色
                .setBackgroundColorResource(R.color.white)
                .setGravity(Gravity.RIGHT| Gravity.TOP)//位置，默认右上角;
                .setHideOnSelect(true);
        bottomNavigationView= (BottomNavigationBar) findViewById(R.id.main_bottom_navigationbar);
        bottomNavigationView.setBarBackgroundColor(R.color.top_background);
        addMenuItem();

        setStatusBarColor(Color.TRANSPARENT,1);
        bottomNavigationView.setTabSelectedListener(this);
    }

    @Override
    protected void obtainData() {
        setDefaultFrament();//设置默认的Fragment
    }

    @Override
    protected void initEvent() {

    }
}
