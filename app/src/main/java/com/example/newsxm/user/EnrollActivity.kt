package com.example.newsxm.user

import android.content.Intent
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.example.newsxm.R
import com.example.newsxm.databinding.ActivityEnrollBinding
import com.example.newsxm.entity.UserEntity
import com.example.newsxm.mvvm.base.BaseActivity
import com.example.newsxm.mvvm.viewmodel.EnrollViewModel
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

class EnrollActivity : BaseActivity<ActivityEnrollBinding, EnrollViewModel>() {
    override fun layout(): Int {
        return R.layout.activity_enroll
    }

    override fun data(): Class<EnrollViewModel> {
        return EnrollViewModel::class.java
    }

    override fun initialize() {
        binding.enroll.setOnClickListener {
            var map : MutableMap<String,String> = mutableMapOf()
            map.put("username",binding.username.editableText.toString())
            map.put("password",binding.password.editableText.toString())
            map.put("repassword",binding.repassword.editableText.toString())
            var json = Gson().toJson(map)
            var requestBody = RequestBody.create(MediaType.parse("application/json"), json)
            viewModel.enroll(requestBody)
        }
    }

    override fun mutual() {
        viewModel.enroll.observe(this,object : Observer<UserEntity>{
            override fun onChanged(value: UserEntity) {
                if (value!=null){
                    if (value.code==200){
                        var intent = Intent(this@EnrollActivity, LoginActivity::class.java)
                        startActivity(intent)
                        ToastUtils.showLong("注册成功")
                    }else{
                        ToastUtils.showLong(value.message)

                    }
                }
            }

        })
    }

}