package com.example.newsxm.video

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsxm.R
import com.example.newsxm.adapter.VideoAdapter
import com.example.newsxm.databinding.FragmentVideoBinding
import com.example.newsxm.entity.VideoData
import com.example.newsxm.entity.VideoEntity
import com.example.newsxm.mvvm.base.BaseFragment
import com.example.newsxm.mvvm.viewmodel.VideoViewModel


class VideoFragment : BaseFragment<FragmentVideoBinding,VideoViewModel>() {
    var videoList : MutableList<VideoData> = mutableListOf()
    var videoAdapter = VideoAdapter()
    override fun layout(): Int {
        return R.layout.fragment_video
    }

    override fun data(): Class<VideoViewModel> {
        return VideoViewModel::class.java
    }

    override fun mutual() {
        viewModel.videoList.observe(this,object : Observer<VideoEntity>{
            override fun onChanged(value: VideoEntity) {
                if (value!!.code==200){
                    videoList.addAll(value.data)
                    videoAdapter.data.addAll(videoList)
                    binding.recyclerviewVideo.adapter=videoAdapter
                    videoAdapter.notifyDataSetChanged()
                    binding.recyclerviewVideo.layoutManager = GridLayoutManager(activity,2)
                    videoAdapter.setOnItemClickListener { adapter, view, position ->
                        var intent = Intent(activity, video_Activity::class.java)
                        intent.putExtra("video",videoList.get(position))
                        startActivity(intent)
                    }

                }
            }

        })
    }

    override fun initialize() {
        viewModel.video()
    }

}