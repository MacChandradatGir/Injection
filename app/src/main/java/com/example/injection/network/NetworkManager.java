package com.example.injection.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;


public class NetworkManager {

    private Retrofit retrofit;

    public NetworkManager(){
        //consructor
    }

    public Retrofit provideRetrofitClient(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(provideRxJavaCallAdapter())
                .addConverterFactory(provideConvertFactory())
                .client(provideHttpClient())
                .build();
    }

    public OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor((provideHttpInterceptor()))
                .build();
    }

    private HttpLoggingInterceptor provideHttpInceptor(){
        HttpLoggingInterceptor interceptor= new HttpLoggingInterceptor();

    }




}
