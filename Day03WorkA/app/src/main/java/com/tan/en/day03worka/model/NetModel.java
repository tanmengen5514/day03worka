package com.tan.en.day03worka.model;

import android.util.Log;

import com.tan.en.day03worka.ApiService;
import com.tan.en.day03worka.bean.DatasBean;
import com.tan.en.day03worka.bean.MyBean;
import com.tan.en.day03worka.presenter.NetPresenter;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by en on 2019/9/20.
 */

public class NetModel {

    public void getDatas(final NetCallBack netCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MyBean> observable = apiService.geturl();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        if (myBean.getDatas() != null && myBean != null) {
                            netCallBack.getNetDatas((ArrayList<DatasBean>) myBean.getDatas());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        netCallBack.getNetFail(e.getMessage());
                        Log.i("111",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface NetCallBack {
        void getNetDatas(ArrayList<DatasBean> datasBeans);
        void getNetFail(String s);
    }
}
