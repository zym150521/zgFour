package com.example.newsxm.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.newsxm.R
import com.example.newsxm.entity.VideoData

class VideoAdapter :BaseQuickAdapter<VideoData,BaseViewHolder>(layoutResId = R.layout.layout_video) {
    override fun convert(helper: BaseViewHolder, item: VideoData) {
        Glide.with(helper.itemView.context).load(item.videomainimg).into(helper.getView(R.id.img_video))
        helper.setText(R.id.text_video, item.caption)
    }
}