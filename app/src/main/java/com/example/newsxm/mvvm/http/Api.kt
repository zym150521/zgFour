package com.example.newsxm.mvvm.http

import com.example.newsxm.entity.BannerEntity
import com.example.newsxm.entity.ClassifyEntity
import com.example.newsxm.entity.CommentEntity
import com.example.newsxm.entity.NewsEntity
import com.example.newsxm.entity.UserEntity
import com.example.newsxm.entity.VideoEntity
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    //新闻
    @GET("/news/news?currentPage=1&&pageSize=10")
    fun news(@Query ("newstypeid") id : Int) : Observable<NewsEntity>
    //新闻评论
    @GET("/comment/getCommentByNewsId?")
    fun comment(@Query ("newsId") id: Int): Observable<CommentEntity>
    //轮播图
    @GET("/banner/json")
    fun banner() : Observable<BannerEntity>
    //分类
    @GET("/news/type")
    fun classify() : Observable<ClassifyEntity>
    //视频
    @GET("/video/findVideos?currentPage=1&pageSize=10")
    fun video() : Observable<VideoEntity>
    //注册
    @POST("/user/register")
    fun enroll(@Body body : RequestBody) : Observable<UserEntity>
    //登录
    @POST("/user/loginjson")
    fun login(@Body body : RequestBody) : Observable<UserEntity>
}