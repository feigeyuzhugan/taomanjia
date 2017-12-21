package com.zhongzi.taomanjia.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.UserCenterRes;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 * 九宫格---个人中心
 */

public class UserCenterAdapter extends BaseAdapter {
    private List<UserCenterRes> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private Drawable mDrawable;
    public UserCenterAdapter(List<UserCenterRes> list, Context context){
        this.mList=list;
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.item_usercenter_gridview,parent,false);
            viewHolder.tv= (TextView) convertView.findViewById(R.id.item_user_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        UserCenterRes userCenterRes=mList.get(position);
        viewHolder.tv.setCompoundDrawables(null,getDrawable(userCenterRes.getId()),null,null);
        viewHolder.tv.setText(userCenterRes.getName());
        return convertView;
    }

    public static class ViewHolder {
        TextView tv;
    }

    private Drawable getDrawable(int drawableId) {
        mDrawable=mContext.getResources().getDrawable(drawableId);
        mDrawable.setBounds(0,0,mDrawable.getIntrinsicWidth(),mDrawable.getIntrinsicHeight());
        return mDrawable;
    }
}
