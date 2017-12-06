package com.zhongzi.taomanjia.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v4.content.PermissionChecker;
import android.support.v4.view.KeyEventCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
//import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.LoginEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.forget.UserCenterToEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.user.ToUserCenterEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.FileStorageUtils;
import com.zhongzi.taomanjia.utils.MaterialDialogUtils;
import com.zhongzi.taomanjia.utils.PermissionUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.camera.CameraUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.BaseActivity;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.activity.login.LoginActivity;
import com.zhongzi.taomanjia.view.fragment.MainFragment;
import com.zhongzi.taomanjia.view.fragment.ProductFragment;
import com.zhongzi.taomanjia.view.fragment.ShoppingFragment;
import com.zhongzi.taomanjia.view.fragment.UserFragment;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.widget.MaterialDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener,PermissionUtil.OnRequestPermissionsResultCallbacks{
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
    //-----照相
    private Uri imageUri;//原图保存地址
    private Uri imageUriStr;//传递给个人中心
    //-----照相
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
        EventBusUtil.register(this);
    }

    @Override
    protected void initBarColor() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }

    //user界面跳转转某个界面
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void goActivty(UserCenterToEvent event){
        switch (event.getType()){
            case BaseConstants.PERMISSION_CAMERA://照相权限
//                ToastUtil.show("照相权限");
                requestCameraPermisson();
                break;
        }
    }

    public void requestCameraPermisson() {
        //manifest.xml清单中需配置<uses-permission android:name="android.permission.CAMERA" />
        //manifest.xml清单中需配置<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
        //manifest.xml清单中需配置<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//        PermissionUtil.requestPerssions(this, BaseConstants.PERMISSION_CAMERA, Manifest.permission.CAMERA,  Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
       boolean has= PermissionUtil.getCameraPermissions(this, BaseConstants.PERMISSION_CAMERA);
        if (has){
            ToastUtil.show("有.....");
            callPhone();
        }
    }

    /**
     *  弹一个选择照相，图片，取消
     */
    private void callPhone() {
        imageUri=FileStorageUtils.createImageUri(this);
        MaterialDialogUtils.showCallPhoneDialog(imageUri,this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms, boolean isAllGranted) {
        for (String str:perms){
            LogUtil.e("授权"+str);
        }
        if (requestCode==BaseConstants.PERMISSION_CAMERA){
            if (perms.get(0).equals("android.permission.CAMERA")){
                ToastUtil.show("弹出....");
                callPhone();
            }
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms, boolean isAllDenied) {
        if (requestCode==BaseConstants.PERMISSION_CAMERA){
            MaterialDialogUtils.showPermissionDialog("设置权限","前往设置界面设置权限",this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionUtil.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case BaseConstants.REQUEST_SELECT_CAMERA://

                if (resultCode==RESULT_OK){
                    imageUriStr=imageUri;
                    CameraUtils.cropPhoto(imageUri,this);
                }
                break;
            case BaseConstants.REQUEST_PICTURE_CUT://REQUEST_PICTURE_CUT
                if (resultCode==RESULT_OK){
                    EventBusUtil.postEvent(new ToUserCenterEvent(BaseConstants.UPLOADPHOTOS,imageUriStr,BaseConstants.UPLOADPHOTOS));
                }
                break;
            case BaseConstants.REQUEST_PICK_IMAGE://选择图库
                if (resultCode==RESULT_OK) {
                    imageUriStr = CameraUtils.selectPhoto(data, this);
                    CameraUtils.cropPhoto(imageUriStr, this);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK==keyCode){
            MaterialDialogUtils.showExitDialog("退出","是否退出",this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
