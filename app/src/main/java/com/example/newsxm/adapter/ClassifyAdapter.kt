package com.example.newsxm.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.newsxm.R
import com.example.newsxm.entity.ClassifyData

class ClassifyAdapter : BaseQuickAdapter<ClassifyData,BaseViewHolder>(layoutResId = R.layout.layout_home_classify){
    override fun convert(helper: BaseViewHolder, item: ClassifyData) {
        helper.setText(R.id.text_classify,item.typename)
    }

}