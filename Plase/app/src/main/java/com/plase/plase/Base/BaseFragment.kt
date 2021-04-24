package com.plase.plase.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.plase.plase.R

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

   public lateinit var  binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }




    open fun getLayoutId() : Int {
         return 0
     }

}