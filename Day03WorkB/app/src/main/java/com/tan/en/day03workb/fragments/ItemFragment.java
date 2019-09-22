package com.tan.en.day03workb.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tan.en.day03workb.R;
import com.tan.en.day03workb.adapter.MyAdapterViewPager;
import com.tan.en.day03workb.bean.FuliBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {


    private View view;
    private ViewPager mVp;
    private int mposition;

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(View view) {
        mVp = (ViewPager) view.findViewById(R.id.vp);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getList(ArrayList<FuliBean.ResultsBean> list){
        ArrayList<View> views = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            View view=LayoutInflater.from(getActivity()).inflate(R.layout.layout_image,null);
            views.add(view);
            ImageView iv = view.findViewById(R.id.iv_image);
            Glide.with(getActivity())
                    .load(list.get(i).getUrl())
                    .into(iv);
            int count=i+1;
            TextView tv = view.findViewById(R.id.tv);
            tv.setText(count+"/"+list.size());
        }
        //创建适配器
        MyAdapterViewPager myAdapterViewPager = new MyAdapterViewPager(views);
        //设置适配器
        mVp.setAdapter(myAdapterViewPager);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPosition(int position){
        mposition = position;
    }
}
