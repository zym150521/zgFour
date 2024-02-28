package com.example.newsxm.main

import android.content.Intent
import com.example.newsxm.R
import com.example.newsxm.databinding.ActivityMainBinding
import com.example.newsxm.mvvm.base.BaseActivity
import com.example.newsxm.mvvm.viewmodel.HomeViewModel
import java.util.Timer
import java.util.TimerTask

class MainActivity : BaseActivity<ActivityMainBinding,HomeViewModel>() {
    var time : Int = 6
    var timer = Timer()
    override fun layout(): Int {
        return R.layout.activity_main
    }
    override fun data(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun initialize() {
        timer.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread {
                    if (time>0){
                        time--
                        val toString = time.toString()
                        binding.text.setText("跳过  "+ toString +"")
                    }else if (time==0){
                        var intent = Intent(this@MainActivity, MainActivity3::class.java)
                        startActivity(intent)
                        timer.cancel()
                    }
                }
            }
        },0,1000)

    }
    override fun mutual() {
    }

}