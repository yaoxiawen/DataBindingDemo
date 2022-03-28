package com.example.databindingdemo

import android.view.View
import android.widget.Toast


public class ItemModel constructor(var content: String) {
    fun onItemClick(view: View) {
        Toast.makeText(view.context, "点击了：$content", Toast.LENGTH_SHORT).show()
    }
}