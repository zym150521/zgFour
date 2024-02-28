package com.example.newsxm.adapter

import android.provider.Settings.Global
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.newsxm.R
import com.example.newsxm.entity.Data

class HomeAdapter : BaseQuickAdapter<Data,BaseViewHolder>(layoutResId = R.layout.layout_home_news){
    override fun convert(helper: BaseViewHolder, item: Data) {
        Glide.with(helper.itemView.context).load(item.mainimgurl).into(helper.getView(R.id.news_img))
        helper.setText(R.id.news_text,item.title)
    }

}