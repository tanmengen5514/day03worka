package com.tan.en.day03work2.model;

import com.tan.en.day03work2.ApiService;
import com.tan.en.day03work2.bean.WorkBean;
import com.tan.en.day03work2.presenter.ItemPresenter;

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
 * Created by en on 2019/9/22.
 */

public class ItemModel {

    public void setItemResults(final ItemCallBack itemCallBack, int mid) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.work_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<WorkBean> observable = apiService.getWork(mid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WorkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WorkBean workBean) {
                        if (workBean != null && workBean.getBody().getResult() != null) {
                            itemCallBack.getItemResults(workBean.getBody());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        itemCallBack.getItemFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface ItemCallBack {
        void getItemResults(WorkBean.BodyBean resultBeans);
        void getItemFail(String s);
    }
}
