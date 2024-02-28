package com.example.newsxm

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.example.newsxm.databinding.FragmentBlankBinding
import com.example.newsxm.mvvm.base.BaseFragment
import com.example.newsxm.mvvm.viewmodel.BlankViewModel
import com.example.newsxm.user.LoginActivity

class BlankFragment : BaseFragment<FragmentBlankBinding, BlankViewModel>() {
    override fun layout(): Int {
        return R.layout.fragment_blank
    }

    override fun data(): Class<BlankViewModel> {
        return BlankViewModel::class.java
    }

    override fun mutual() {
       binding.please.setOnClickListener {
           var intent = Intent(activity, LoginActivity::class.java)
           startActivity(intent)
       }
        var name = Intent.getIntent("name")
        if (name != null){
            binding.name.setText(""+name)
        }
    }
    override fun initialize() {
        Glide.with(binding.avatar.context).load("https://c-ssl.dtstatic.com/uploads/blog/202102/14/20210214164023_1b4ee.thumb.1000_0.jpg").circleCrop().into(binding.avatar)
    }



}