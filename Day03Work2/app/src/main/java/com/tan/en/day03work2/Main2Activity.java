package com.tan.en.day03work2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.tan.en.day03work2.adapter.MyAdapter;
import com.tan.en.day03work2.adapter.MyAdapterFragment;
import com.tan.en.day03work2.bean.TeacherBean;
import com.tan.en.day03work2.bean.WorkBean;
import com.tan.en.day03work2.fragment.Home2Fragment;
import com.tan.en.day03work2.fragment.Home3Fragment;
import com.tan.en.day03work2.fragment.HomeFragment;
import com.tan.en.day03work2.presenter.ItemPresenter;
import com.tan.en.day03work2.view.ItemView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements ItemView {

    private RecyclerView mRel;
    private Toolbar mToolbar;
    private int mid;
    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<TeacherBean.BodyBean.ResultBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initRel();
        ItemPresenter itemPresenter = new ItemPresenter(this);
        itemPresenter.setItemResults(mid);
        EventBus.getDefault().register(this);
    }

    private void initRel() {
        mRel.setLayoutManager(new LinearLayoutManager(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getId(int id) {
        mid = id;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getResults(TeacherBean.BodyBean.ResultBean resultBean) {
        //创建集合
        list = new ArrayList<>();
        //添加数据
        list.add(resultBean);
        //创建适配器
        MyAdapter myAdapter = new MyAdapter(this, list);
        //设置适配器
        mRel.setAdapter(myAdapter);
        //刷新适配器
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
    }

    @Override
    public void setItemResult(WorkBean.BodyBean result) {
        String s = result.getResult().toString();
        String s1 = result.toString();
        Log.i("111", s1);
        Log.i("111", s);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        //创建fragment对象
        HomeFragment homeFragment = new HomeFragment();
        Home2Fragment home2Fragment = new Home2Fragment();
        Home3Fragment home3Fragment = new Home3Fragment();
        fragments.add(homeFragment);
        fragments.add(home2Fragment);
        fragments.add(home3Fragment);
        items.add("介绍");
        items.add("课程");
        items.add("专题");
        //创建适配器
        MyAdapterFragment myAdapterFragment = new MyAdapterFragment(getSupportFragmentManager(), fragments, items);
        mVp.setAdapter(myAdapterFragment);
        mTab.setupWithViewPager(mVp);
    }

    @Override
    public void setItemFail(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
