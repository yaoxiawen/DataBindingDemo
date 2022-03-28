package com.example.databindingdemo

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

/**
 *
使用ObservableField<>，泛型可以填入自己需要的类型，注意必须要初始化。
对于基本数据类型也可以直接使用ObservableBoolean, ObservableByte, ObservableChar, ObservableShort, ObservableInt, ObservableLong, ObservableFloat, ObservableDouble和ObservableParcelable。
 */
class ObservableModel {
    var field = ObservableField<String>()
    var age = ObservableInt()
}