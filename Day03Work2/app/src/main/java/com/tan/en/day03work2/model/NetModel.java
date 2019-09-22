package com.tan.en.day03work2.model;

import android.util.Log;

import com.tan.en.day03work2.ApiService;
import com.tan.en.day03work2.bean.TeacherBean;
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

public class NetModel {

    public void getNetResults(final NetCallBack netCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.teacher_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<TeacherBean> observable = apiService.getTeacher();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeacherBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeacherBean teacherBean) {
                        if (teacherBean!=null&&teacherBean.getBody().getResult()!=null){
                            netCallBack.setNetResults((ArrayList<TeacherBean.BodyBean.ResultBean>) teacherBean.getBody().getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                     netCallBack.setNetFail(e.getMessage());
                        Log.i("111",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface NetCallBack{
        void setNetResults(ArrayList<TeacherBean.BodyBean.ResultBean> results);
        void setNetFail(String s);
    }
}
