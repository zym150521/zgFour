package com.example.newsxm.user

import android.content.Intent
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.example.newsxm.R
import com.example.newsxm.databinding.ActivityLoginBinding
import com.example.newsxm.entity.UserEntity
import com.example.newsxm.main.MainActivity3
import com.example.newsxm.mvvm.base.BaseActivity
import com.example.newsxm.mvvm.viewmodel.LoginViewModel
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override fun layout(): Int {
        return R.layout.activity_login
    }

    override fun data(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun initialize() {

        binding.enroll.setOnClickListener {
            var intent = Intent(this, EnrollActivity::class.java)
            intent.putExtra("name",binding.username.editableText.toString())
            startActivity(intent)

        }
        binding.login.setOnClickListener {
            var map : MutableMap<String,String> = mutableMapOf()
            map.put("username",binding.username.editableText.toString())
            map.put("password",binding.password.editableText.toString())
            var json = Gson().toJson(map)
            var requestBody = RequestBody.create(MediaType.parse("application/json"), json)
            viewModel.login(requestBody)
        }



    }

    override fun mutual() {
        viewModel.loginList.observe(this,object : Observer<UserEntity> {
            override fun onChanged(value: UserEntity) {
                if (value!=null){
                    if (value.code==200){
                        var intent = Intent(this@LoginActivity, MainActivity3::class.java)
                        startActivity(intent)
                        ToastUtils.showLong("登录成功")
                    }else{
                        ToastUtils.showLong(value.message)
                    }
                }
            }

        })
    }

}