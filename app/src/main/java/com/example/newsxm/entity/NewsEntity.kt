package com.example.newsxm.entity

import java.io.Serializable

data class NewsEntity(
    val code: Int,
    val `data`: List<Data>,
    val message: String
):Serializable

data class Data(
    val auth: String,
    val description: String,
    val id: Int,
    val istop: String,
    val mainimgurl: String,
    val newstypeid: Int,
    val sourcesiteid: Int,
    val sourcesitename: String,
    val sourceurl: String,
    val title: String
):Serializable