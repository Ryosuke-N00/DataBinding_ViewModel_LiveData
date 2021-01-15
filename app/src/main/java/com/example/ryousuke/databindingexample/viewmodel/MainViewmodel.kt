package com.example.ryousuke.databindingexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewmodel: ViewModel() {

    //LiveData(こいつはライフサイクルの変化に対応していける)
    private val _number = MutableLiveData<Int>()

    //LiveData型でかつ_numberを教えてくれるメソッドで代用できる
    /*val number = LiveData<Int>
        get() = _number*/

    //メソッドを使って、Mutableの中身を読み取り専用に変える
    fun numberGet() : LiveData<Int>{
        return _number
    }

    //インスタンス生成時に中身に0を設定する
    init {
        _number.value = 0
    }


    fun addNumber(){
        _number.value = (_number.value)?.plus(1)
    }

    //ViewModelがバックグラウンド状態、タスクを切るときに行う処理
    //このとき、ViewModelは(Fragment,Activity,Contextなどの引数を持ってはいけない)
    //Application Contextは、ライフサイクルに対応しているので引数として与えてよい

    override fun onCleared() {
        super.onCleared()
    }
}