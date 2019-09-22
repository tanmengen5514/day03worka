package com.tan.en.day03work2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.tan.en.day03work2.R;
import com.tan.en.day03work2.bean.TeacherBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by en on 2019/9/22.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TeacherBean.BodyBean.ResultBean> list;
    private ArrayList<String> strings;

    public MyAdapter(Context context, ArrayList<TeacherBean.BodyBean.ResultBean> list) {
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
        holder1.name_item.setText(list.get(position).getTeacherName());
        holder1.title_item.setText(list.get(position).getTitle());
        Glide.with(context)
                .load(list.get(position).getTeacherPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder1.iv_item);
        List<?> type = list.get(position).getTeacherType();
        Log.i("111", type.toString());
        strings = new ArrayList<>();
        for (int i = 0; i < type.size(); i++) {
            strings.add(type.get(i).toString());
        }
        holder1.type_item.setText(strings.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOnClickListener!=null){
                    myOnClickListener.myOnClick(position);
                }
            }
        });
    }

    //定义接口回调
    public interface MyOnClickListener {
        void myOnClick(int position);
    }
    private MyOnClickListener myOnClickListener;

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_item;
        TextView name_item;
        TextView title_item;
        TextView type_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            name_item = itemView.findViewById(R.id.name_item);
            iv_item = itemView.findViewById(R.id.iv_item);
            title_item = itemView.findViewById(R.id.title_item);
            type_item = itemView.findViewById(R.id.type_item);
        }
    }
}
