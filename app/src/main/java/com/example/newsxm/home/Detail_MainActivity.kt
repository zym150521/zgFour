package com.example.newsxm.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.newsxm.R
import com.example.newsxm.adapter.CommentAdapter
import com.example.newsxm.databinding.ActivityDetailMainBinding
import com.example.newsxm.entity.CommentData
import com.example.newsxm.entity.CommentEntity
import com.example.newsxm.entity.Data
import com.example.newsxm.mvvm.base.BaseActivity
import com.example.newsxm.mvvm.viewmodel.HomeViewModel


class Detail_MainActivity : BaseActivity<ActivityDetailMainBinding, HomeViewModel>() {
    var lists : MutableList<CommentData> = mutableListOf()
    var commentAdapter= CommentAdapter()
    override fun layout(): Int {
        return R.layout.activity_detail_main
    }

    override fun data(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun initialize() {
        var data = intent.getSerializableExtra("data") as Data
        if (data!=null ){
            binding.authorText.setText(data.sourcesitename+"")
            binding.substanceText.setText(data.description+"")
            binding.titleText.setText(data.title+"")
            binding.authorTextOne.setText(data.auth+" ")
            Glide.with(this).load(data.mainimgurl).into(binding.riv)
            Glide.with(this).load(data.mainimgurl).circleCrop().into(binding.avatarImage)
            viewModel.comment(data.id)
            viewModel.commentList.observe(this@Detail_MainActivity,object :Observer<CommentEntity>{
                override fun onChanged(value: CommentEntity) {
                    if (value!=null){
                        if (value.code==200){
                            lists.addAll(value.data)
                            commentAdapter.data.addAll(lists)
                            binding.recyclerview.adapter=commentAdapter
                            commentAdapter.notifyDataSetChanged()
                            binding.recyclerview.layoutManager=GridLayoutManager(this@Detail_MainActivity,1)
                        }
                    }
                }

            })
        }
        binding.returnImage.setOnClickListener {
            finish()
        }
    }

    override fun mutual() {
    }

}