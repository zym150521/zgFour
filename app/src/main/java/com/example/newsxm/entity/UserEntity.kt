package com.example.newsxm.entity

data class UserEntity(
    val code: Int,
    val `data`: UserData,
    val message: String
)

data class UserData(
    val address: String,
    val admin: Boolean,
    val birth: String,
    val coinCount: Int,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val sex: String,
    val token: String,
    val type: Int,
    val username: String
)