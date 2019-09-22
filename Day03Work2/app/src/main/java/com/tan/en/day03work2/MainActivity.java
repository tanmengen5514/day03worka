package com.tan.en.day03work2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.tan.en.day03work2.adapter.MyAdapter;
import com.tan.en.day03work2.bean.TeacherBean;
import com.tan.en.day03work2.presenter.NetPresenter;
import com.tan.en.day03work2.view.NetView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetView{

    private Toolbar mToolbar;
    private RecyclerView mRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRel();
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getNetResults();
    }

    private void initRel() {
        mRel.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initView() {
        //找到控件对象
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置标题内容
        mToolbar.setTitle("");
        //支持
        setSupportActionBar(mToolbar);
        mRel = (RecyclerView) findViewById(R.id.rel);
    }

    @Override
    public void getResults(ArrayList<TeacherBean.BodyBean.ResultBean> resultBeans) {
        //创建数据源
        final ArrayList<TeacherBean.BodyBean.ResultBean> list = new ArrayList<>();
        //添加数据
        list.addAll(resultBeans);
        //创建适配器
        MyAdapter myAdapter = new MyAdapter(this, list);
        //设置适配器
        mRel.setAdapter(myAdapter);
        //刷新适配器
        myAdapter.notifyDataSetChanged();
        myAdapter.setMyOnClickListener(new MyAdapter.MyOnClickListener() {
            @Override
            public void myOnClick(int position) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                int id = list.get(position).getID();
                startActivity(intent);
                TeacherBean.BodyBean.ResultBean resultBean = list.get(position);
                EventBus.getDefault().postSticky(resultBean);
                EventBus.getDefault().postSticky(id);
            }
        });
    }

    @Override
    public void getFail(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
