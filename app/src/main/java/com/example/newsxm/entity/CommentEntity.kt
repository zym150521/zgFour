package com.example.newsxm.entity

data class CommentEntity(
    val code: Int,
    val `data`: List<CommentData>,
    val message: String
)

data class CommentData(
    val childcount: Int,
    val createtime: String,
    val icon: String,
    val id: Int,
    val msg: String,
    val parentid: Int,
    val rootid: Int,
    val tousername: String,
    val type: Int,
    val username: String
)