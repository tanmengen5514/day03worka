package com.tan.en.day03workb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tan.en.day03workb.R;
import com.tan.en.day03workb.bean.FuliBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<FuliBean.ResultsBean> list;

    public MyAdapter(Context context, ArrayList<FuliBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Glide.with(context).load(list.get(position).getUrl())
                .into(holder1.iv_item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOnClickListener!=null){
                    myOnClickListener.myOnClickListener(position);
                }
            }
        });
    }

    //定义接口回调
    public interface MyOnClickListener {
        void myOnClickListener(int position);
    }

    //定义成员变量
    private MyOnClickListener myOnClickListener;
    //定义set方法

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_item = itemView.findViewById(R.id.iv_item);
        }
    }
}
