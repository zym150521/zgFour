package com.example.newsxm.adapter

import android.widget.ImageView
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.newsxm.R
import com.example.newsxm.entity.CommentData

class CommentAdapter :BaseQuickAdapter<CommentData,BaseViewHolder>(layoutResId = R.layout.layout_comment) {
    var boolean : Boolean =false
    override fun convert(helper: BaseViewHolder, item: CommentData) {
        helper.setText(R.id.username,item.username)
        helper.setText(R.id.msg,item.msg)
        helper.setText(R.id.createtime,item.createtime)
        helper.setText(R.id.thumbs,""+item.id)
        helper.getView<ImageView>(R.id.thumbs_up).setOnClickListener {
            if (boolean==true){

                ToastUtils.showLong("点赞")
                item.id+1
                helper.getView<ImageView>(R.id.thumbs_up).setImageResource(R.drawable.baseline_favorite_26)
                boolean=false
                helper.setText(R.id.thumbs,""+item.id)

            }else{
                item.id-1

                ToastUtils.showLong("取消点赞")
                helper.getView<ImageView>(R.id.thumbs_up).setImageResource(R.drawable.baseline_favorite_border_26)
                boolean=true
                helper.setText(R.id.thumbs,""+item.id)
              
            }
        }
        Glide.with(helper.itemView.context).load(item.icon).circleCrop().into(helper.getView(R.id.icon))
    }
}