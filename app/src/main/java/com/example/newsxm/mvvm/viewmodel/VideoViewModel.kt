package com.example.newsxm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsxm.entity.VideoEntity
import com.example.newsxm.mvvm.http.Retrofits
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class VideoViewModel : ViewModel() {
    var videoList : MutableLiveData<VideoEntity> = MutableLiveData()
    fun video(){
        Retrofits.getinternet().getRetrofit().video()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<VideoEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: VideoEntity) {
                    videoList.value=t
                }

            })
    }

}