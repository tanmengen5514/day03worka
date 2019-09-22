package com.tan.en.day03workb;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tan.en.day03workb.adapter.MyAdapter;
import com.tan.en.day03workb.bean.FuliBean;
import com.tan.en.day03workb.fragments.ItemFragment;
import com.tan.en.day03workb.presenter.NetPresenter;
import com.tan.en.day03workb.view.NetView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetView {

    private RecyclerView mRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRel();
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getResults();
    }

    private void initRel() {
        mRel.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        mRel.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel);
    }

    @Override
    public void getNewDatas(ArrayList<FuliBean.ResultsBean> resultsBeans) {
        //创建数据源
        final ArrayList<FuliBean.ResultsBean> list = new ArrayList<>();
        //添加数据
        list.addAll(resultsBeans);
        //创建适配器
        MyAdapter myAdapter = new MyAdapter(this, list);
        //设置适配器
        mRel.setAdapter(myAdapter);
        //刷新适配器
        myAdapter.notifyDataSetChanged();
        //定义监听方法
        myAdapter.setMyOnClickListener(new MyAdapter.MyOnClickListener() {
            @Override
            public void myOnClickListener(int position) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                ItemFragment itemFragment = new ItemFragment();
                transaction.add(R.id.contain,itemFragment).commit();
                EventBus.getDefault().post(list);
                EventBus.getDefault().post(position);
            }
        });
    }

    @Override
    public void getFail(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
