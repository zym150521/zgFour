package com.example.newsxm.home

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.bumptech.glide.Glide
import com.example.newsxm.R
import com.example.newsxm.adapter.ClassifyAdapter
import com.example.newsxm.adapter.HomeAdapter
import com.example.newsxm.databinding.FragmentHomeBinding

import com.example.newsxm.entity.BannerEntity
import com.example.newsxm.entity.ClassifyData
import com.example.newsxm.entity.ClassifyEntity
import com.example.newsxm.entity.Data
import com.example.newsxm.entity.NewsEntity
import com.example.newsxm.mvvm.base.BaseFragment
import com.example.newsxm.mvvm.viewmodel.HomeViewModel
import com.youth.banner.loader.ImageLoader


class Home_Fragment :BaseFragment<FragmentHomeBinding,HomeViewModel>() {
    var list : MutableList<Data> = mutableListOf()
    var adapter = HomeAdapter()
    var bannerList : MutableList<String> = mutableListOf()
    var classifyList :MutableList<ClassifyData> = mutableListOf()
    var classifyAdapter = ClassifyAdapter()
    var ok : Int = 1
    override fun layout(): Int {
        return R.layout.fragment_home_
    }
    override fun data(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
    override fun mutual() {
        //分类
        viewModel.classifyList.observe(this,object : Observer<ClassifyEntity>{
            override fun onChanged(value: ClassifyEntity) {
                if (value!!.code==200){
                    classifyList.addAll(value.data)
                    classifyAdapter.data.addAll(classifyList)
                    binding.classifyRecyclerview.adapter=classifyAdapter
                    binding.classifyRecyclerview.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
                    classifyAdapter.setOnItemClickListener { adapter1, view, position ->
                        adapter.notifyDataSetChanged()
                        list.clear()
                        adapter.data.clear()
                        ok=position+1
                        viewModel.news(ok)

                    }
                }
            }
        })
        //banner
        viewModel.bannerList.observe(this,object :Observer<BannerEntity>{
            override fun onChanged(value: BannerEntity) {
                for (i in 0 until value.data.size){
                    bannerList.add(value.data.get(i).imagePath)
                }
                binding.banner.setImages(bannerList)
                binding.banner.setImageLoader(object : ImageLoader(){
                    override fun displayImage(
                        context: Context?,
                        path: Any?,
                        imageView: ImageView?
                    ) {
                        Glide.with(context!!).load(path).into(imageView!!)
                    }
                }).start()
            }
        })
        //新闻赋值
        viewModel.newsList.observe(this,object : Observer<NewsEntity>{
            override fun onChanged(value: NewsEntity) {
               if (value!!.code==200){
                   list.addAll(value.data)
                   adapter.data.addAll(list)
                   adapter.notifyDataSetChanged()
                   binding.newsRecyclerview.adapter = adapter
                   binding.newsRecyclerview.layoutManager = GridLayoutManager(activity,1)
                   adapter.setOnItemClickListener { adapter1, view, position ->
                       var intent = Intent(activity, Detail_MainActivity::class.java)
                       intent.putExtra("data",list.get(position))
                       startActivity(intent)
                   }
               }
            }

        })
    }
    override fun initialize() {
        //分类
        viewModel.classify()
        //新闻
        viewModel.news(ok)
        //banner
        viewModel.banner()
    }
}