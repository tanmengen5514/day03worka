package com.tan.en.day03worka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xts.greendaodemo.db.DatasBeanDao;
import com.tan.en.day03worka.adapter.MyAdapter;
import com.tan.en.day03worka.bean.DatasBean;
import com.tan.en.day03worka.bean.MyBean;
import com.tan.en.day03worka.presenter.NetPresenter;
import com.tan.en.day03worka.view.NetView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetView {

    private RecyclerView mRel;
    private ArrayList<DatasBean> list;
    private DatasBeanDao beanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getDatas();
    }

    @Override
    public void getDatas(ArrayList<DatasBean> datasBeans) {
        list = new ArrayList<>();
        list.addAll(datasBeans);
        //创建适配器
        final MyAdapter myAdapter = new MyAdapter(this, list);
        //设置适配器
        mRel.setAdapter(myAdapter);
        myAdapter.setMyOnClickListener(new MyAdapter.MyOnClickListener() {
            @Override
            public void myOnClick(View view, final int position) {
                final Button btn = view.findViewById(R.id.btn);
                final String s = btn.getText().toString();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        beanDao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
                        myAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public void getFail(String s) {
        Toast.makeText(this, "+"+s, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(this));
    }
}
