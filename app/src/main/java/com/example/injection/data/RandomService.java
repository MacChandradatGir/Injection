package com.example.injection.data;

import com.example.injection.model.RandomUser;
import com.example.injection.network.NetworkManager;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RandomService {

    private RandomAPI randomAPI;

    public RandomService(){
        NetworkManager networkManager = new NetworkManager();
        Retrofit retrofit = networkManager.provideRetrofitClient(RandomAPI.BASE_URL);
        randomAPI = retrofit.create(RandomAPI.class);

    }
    public void getRandomUser(final CallBack callback){
        randomAPI.getRandomUser()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RandomUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(RandomUser randomUser) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    interface CallBack{
        void onRandomUser(RandomUser user);
        void onError(String error);
    }
}
