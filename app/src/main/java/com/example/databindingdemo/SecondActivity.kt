package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding: ActivitySecondBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_second)
        dataBinding.lifecycleOwner = this
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, DataBindingFragment())
        transaction.commit()
    }
}