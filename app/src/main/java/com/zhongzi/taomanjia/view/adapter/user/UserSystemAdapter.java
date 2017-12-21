package com.zhongzi.taomanjia.view.adapter.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */

public class UserSystemAdapter extends RecyclerView.Adapter<UserSystemAdapter.MyViewHolder>  {

    private List<UserSystemRes> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public UserSystemAdapter(List<UserSystemRes> list, Context context){
        mList=list;
        mContext=context;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_user_system,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.time.setText(mList.get(position).getSENDTIME());
        holder.msg.setText(mList.get(position).getMESSAGE());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView time;
        private TextView msg;
        public MyViewHolder(View itemView) {
            super(itemView);
            time= (TextView) itemView.findViewById(R.id.uesr_system_time);
            msg= (TextView) itemView.findViewById(R.id.uesr_system_msg);
        }
    }
}
