package com.example.databindingdemo


import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableMap
import com.example.databindingdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //通过DataBinding加载布局都会对应的生成Binding对象，如ActivityMainBinding，对象名在布局文件名称后加上了一个后缀Binding
        val dataBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        //获取数据
        val user = User("名称", "昵称", true, 20)
        //给通过binding绑定数据
        dataBinding.user = user
        dataBinding.enabled = true
        dataBinding.content = "这是一个按钮"
        //通过binding.id名称---就相当于findviewbyid获取控件对象了
        dataBinding.tvNick.text = user.nick
        dataBinding.bt.setOnClickListener {
            Toast.makeText(this, "成功点击了", Toast.LENGTH_SHORT).show()
        }
        //绑定事件接口
        dataBinding.title1 = "这是按钮1"
        dataBinding.title2 = "这是按钮2"
        dataBinding.title3 = "这是按钮3"
        dataBinding.title4 = "这是点击更新了"
        dataBinding.event = object : EventListener {
            override fun onClick1(view: View) {
                Toast.makeText(this@MainActivity, "绑定接口1点击成功", Toast.LENGTH_SHORT).show()
            }

            override fun onClick2(view: View) {
                Toast.makeText(this@MainActivity, "绑定接口2点击成功", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }

            override fun onClick3(string: String) {
                dataBinding.title3 = string
            }
        }
        //绑定list/map等集合数据
        val list = ArrayList<String>()
        list.add("list-first")
        list.add("list-second")
        val map = HashMap<String, String>()
        map["name"] = "map-name"
        val arrays = arrayOf("arrays-first")
        dataBinding.list = list
        dataBinding.map = map
        dataBinding.arrays = arrays
        //Observable数据改变自动更新
        val observableModel = ObservableModel()
        observableModel.field.set("更新前")
        observableModel.age.set(5)
        val observableList = ObservableArrayList<String>()
        observableList.add("更新前")
        val observableMap = ObservableArrayMap<String, String>()
        observableMap["name"] = "更新前"
        dataBinding.observableModel = observableModel
        dataBinding.observableList = observableList
        dataBinding.observableMap = observableMap
        dataBinding.btObservable.setOnClickListener {
            observableModel.field.set("更新后")
            observableModel.age.set(10)
            observableList[0] = "更新后"
            observableMap["name"] = "更新后"
        }
    }
}