package com.example.databindingdemo

class Utils {
    companion object {
        //注解方式实现静态方法只能用在单例类中或companion object关键中
        @JvmStatic
        fun getContent(user: User): String {
            return user.name
        }
    }
}