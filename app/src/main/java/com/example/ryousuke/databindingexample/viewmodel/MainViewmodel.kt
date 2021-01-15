package com.example.ryousuke.databindingexample.viewmodel

import androidx.lifecycle.ViewModel

class MainViewmodel: ViewModel() {

    var number = 0

    fun addNumber(){
        number++
    }

    //ViewModelがバックグラウンド状態、タスクを切るときに行う処理
    //このとき、ViewModelは(Fragment,Activity,Contextなどの引数を持ってはいけない)
    //Application Contextは、ライフサイクルに対応しているので引数として与えてよい
    override fun onCleared() {
        super.onCleared()
    }
}