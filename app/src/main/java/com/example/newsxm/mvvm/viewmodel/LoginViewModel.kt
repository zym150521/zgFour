package com.example.newsxm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsxm.entity.UserEntity
import com.example.newsxm.mvvm.http.Retrofits
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import retrofit2.http.Body

class LoginViewModel:ViewModel() {
    var loginList :MutableLiveData<UserEntity> = MutableLiveData()
    fun login( body : RequestBody){
        Retrofits.getinternet().getRetrofit().login(body)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<UserEntity>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: UserEntity) {
                    loginList.value=t
                }

            })
    }
}