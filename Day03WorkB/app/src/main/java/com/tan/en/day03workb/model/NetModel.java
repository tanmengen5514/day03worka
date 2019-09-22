package com.tan.en.day03workb.model;

import android.util.Log;

import com.tan.en.day03workb.ApiService;
import com.tan.en.day03workb.bean.FuliBean;
import com.tan.en.day03workb.presenter.NetPresenter;

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
    public void getResults(final NetCallBack netCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.fuli_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FuliBean> observable = apiService.getfuli();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                    if (fuliBean.getResults()!=null&&fuliBean!=null){
                        netCallBack.setResults((ArrayList<FuliBean.ResultsBean>) fuliBean.getResults());
                        Log.i("111",fuliBean.toString());
                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        netCallBack.setFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface NetCallBack {
        void setResults(ArrayList<FuliBean.ResultsBean> results);
        void setFail(String s);
    }
}
