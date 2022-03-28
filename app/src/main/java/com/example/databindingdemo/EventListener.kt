package com.example.databindingdemo

import android.view.View

interface EventListener {
    fun onClick1(view: View)
    fun onClick2(view: View)
    fun onClick3(string: String)
}