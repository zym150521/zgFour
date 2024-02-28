package com.example.newsxm.entity

data class ClassifyEntity(
    val code: Int,
    val `data`: List<ClassifyData>,
    val message: String
)

data class ClassifyData(
    val id: Int,
    val typename: String
)