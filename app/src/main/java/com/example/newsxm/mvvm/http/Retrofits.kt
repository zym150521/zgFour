package com.example.newsxm.mvvm.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofits private constructor(){
    companion object{
        var internet : Retrofits ?= null
        fun getinternet():Retrofits {
            if (internet == null){
                internet = Retrofits()
            }
            return internet!!
        }
    }
    var A : Api ?= null
    fun getSite(): Api{
        if (A == null){
            A = getRetrofit()
        }
        return A!!
    }
    fun getRetrofit() :Api {
        var http =HttpLoggingInterceptor()
        http.level= HttpLoggingInterceptor.Level.BASIC
        var okhttp = OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(http)
            .build()
        var record = Retrofit.Builder()
            .baseUrl("http://10.161.9.80:7005/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
            .build()
        return record.create(Api::class.java)
    }
}