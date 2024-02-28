package com.example.newsxm.entity

import java.io.Serializable

data class VideoEntity(
    val code: Int,
    val `data`: List<VideoData>,
    val message: String
) : Serializable

data class VideoData(
    val address: String,
    val authname: String,
    val caption: String,
    val dianzan: Int,
    val guanzhu: Int,
    val headpath: String,
    val id: Int,
    val like_count: Int,
    val publishtime: String,
    val type: Int,
    val videomainimg: String,
    val videopath: String,
    val view_count: Int
):Serializable