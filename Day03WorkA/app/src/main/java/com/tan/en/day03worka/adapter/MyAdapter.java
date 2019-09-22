package com.tan.en.day03worka.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.xts.greendaodemo.db.DatasBeanDao;
import com.tan.en.day03worka.BaseApp;
import com.tan.en.day03worka.R;
import com.tan.en.day03worka.bean.DatasBean;
import com.tan.en.day03worka.bean.MyBean;

import java.util.ArrayList;

/**
 * Created by en on 2019/9/20.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<DatasBean> list;
    private View view;
    private DatasBeanDao beanDao;

    public MyAdapter(Context context, ArrayList<DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1 = (MyViewHolder) holder;
        beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        holder1.author_item.setText(list.get(position).getAuthor());
        holder1.title_item.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder1.iv_item);
        holder1.btn.setText("关注");
        holder1.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatasBean datasBean = list.get(position);
                datasBean.setBtn(1);
                datasBean.setId((long) position);
                String s = holder1.btn.getText().toString();
                if (s.equals("关注")){
                    holder1.btn.setText("取消");
                    beanDao.insertOrReplace(datasBean);
                }else {
                    holder1.btn.setText("关注");
                    beanDao.delete(datasBean);
                }
            }
        });
    }

    public interface MyOnClickListener {
        void myOnClick(View view,int position);
    }

    private MyOnClickListener myOnClickListener;

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_item;
        TextView title_item;
        TextView author_item;
        Button btn;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_item = itemView.findViewById(R.id.iv_item);
            title_item = itemView.findViewById(R.id.title_item);
            author_item = itemView.findViewById(R.id.author_item);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
