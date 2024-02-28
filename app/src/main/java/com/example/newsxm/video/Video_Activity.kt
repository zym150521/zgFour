package com.example.newsxm.video

import android.webkit.WebChromeClient
import com.example.newsxm.R
import com.example.newsxm.databinding.ActivityVideoBinding
import com.example.newsxm.entity.VideoData
import com.example.newsxm.mvvm.base.BaseActivity
import com.example.newsxm.mvvm.viewmodel.VideoViewModel

class video_Activity : BaseActivity<ActivityVideoBinding, VideoViewModel>() {
    override fun layout(): Int {
        return R.layout.activity_video
    }

    override fun data(): Class<VideoViewModel> {
        return VideoViewModel::class.java
    }

    override fun initialize() {
        var video = intent.getSerializableExtra("video") as VideoData
        if (video != null){
            binding.wed.loadUrl(video.videopath)
            binding.wed.webChromeClient = WebChromeClient()
        }
    }

    override fun mutual() {
    }

}