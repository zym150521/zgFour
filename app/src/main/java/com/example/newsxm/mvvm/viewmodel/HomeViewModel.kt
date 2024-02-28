package com.example.newsxm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsxm.entity.BannerEntity
import com.example.newsxm.entity.ClassifyEntity
import com.example.newsxm.entity.CommentEntity
import com.example.newsxm.entity.NewsEntity
import com.example.newsxm.mvvm.http.Retrofits
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel :ViewModel() {
    //新闻评论请求数据
    var commentList : MutableLiveData<CommentEntity> = MutableLiveData()
    fun comment(id : Int){
        Retrofits.getinternet().getRetrofit().comment(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<CommentEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: CommentEntity) {
                    commentList.value=t
                }

            })
    }

    //分类请求数据
    var classifyList : MutableLiveData<ClassifyEntity> = MutableLiveData()

    fun classify(){
        Retrofits.getinternet().getRetrofit().classify()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ClassifyEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }
                override fun onNext(t: ClassifyEntity) {
                    classifyList.value=t
                }

            })
    }


    var bannerList : MutableLiveData<BannerEntity> = MutableLiveData()

    //Banner请求数据
    fun banner(){
        Retrofits.getinternet().getRetrofit().banner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<BannerEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: BannerEntity) {
                    bannerList.value=t
                }

            })
    }
    var newsList : MutableLiveData<NewsEntity> = MutableLiveData()
    //新闻请求数据
    fun news(id : Int){
        Retrofits.getinternet().getRetrofit().news(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<NewsEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: NewsEntity) {
                    newsList.value=t
                }

            })
    }
}