package com.example.newsxm.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<V : ViewDataBinding, T : ViewModel>  : Fragment() {
    lateinit var binding :V
    lateinit var viewModel : T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater,layout(),container,false)
        viewModel = ViewModelProvider(this).get(data())
        initialize()
        mutual()
        return binding.root
    }

    abstract fun layout () : Int
    abstract fun data() : Class<T>
    abstract fun mutual()
    abstract fun initialize()
}