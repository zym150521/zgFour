package com.example.newsxm.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.newsxm.BlankFragment
import com.example.newsxm.CollectionFragment
import com.example.newsxm.R
import com.example.newsxm.adapter.MyViewPager2BottomAdapter
import com.example.newsxm.home.Home_Fragment
import com.example.newsxm.video.VideoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity3 : AppCompatActivity() {
    private var vp01: ViewPager2? = null
    private var bottom: BottomNavigationView? = null
    private val list: MutableList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        vp01 = findViewById<View>(R.id.vp01) as ViewPager2
        bottom = findViewById<View>(R.id.bottom) as BottomNavigationView

        list.add(Home_Fragment())
        list.add(VideoFragment())
        list.add(CollectionFragment())
        list.add(BlankFragment())
        val adapter = MyViewPager2BottomAdapter(this, list)
        vp01!!.adapter = adapter
        bottom!!.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.home_One) {
                vp01!!.currentItem = 0
            } else if (item.itemId == R.id.itsmine_One) {
                vp01!!.currentItem = 3
            }else if (item.itemId == R.id.video_One){
                vp01!!.currentItem = 1
            }else if (item.itemId == R.id.collection_One){
                vp01!!.currentItem = 2
            }
            true
        }
        vp01!!.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottom!!.selectedItemId = R.id.home_One
                    1 -> bottom!!.selectedItemId = R.id.video_One
                    2 -> bottom!!.selectedItemId = R.id.collection_One
                    3 -> bottom!!.selectedItemId = R.id.itsmine_One

                }
            }
        })
    }
}