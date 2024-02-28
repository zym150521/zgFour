package com.example.newsxm.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<V : ViewDataBinding , T :ViewModel> : AppCompatActivity(){
    lateinit var binding :V
    lateinit var viewModel : T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layout())
        viewModel = ViewModelProvider(this).get(data())
        initialize()
        mutual()
    }
    abstract fun layout () : Int
    abstract fun data() : Class<T>
    abstract fun initialize()
    abstract fun mutual()
}