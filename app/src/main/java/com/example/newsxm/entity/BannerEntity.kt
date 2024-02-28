package com.example.newsxm.entity

data class BannerEntity(
    val code: Int,
    val `data`: List<DataBanner>,
    val message: String
)

data class DataBanner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)