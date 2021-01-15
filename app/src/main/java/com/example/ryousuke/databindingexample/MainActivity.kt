package com.example.ryousuke.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.ryousuke.databindingexample.viewmodel.MainViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: MainViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ViewModelのインスタンス化→画面変換があるので定義しよう(内容を保存してくれる)
        viewmodel = ViewModelProvider(this).get(MainViewmodel::class.java)

        /*
        ここの処理は、LiveDataを実装するまでに必要
        //これを追加しないとデータは保存されるけどボタンを押したときでないと保存されているかがわからない
        number_textView.text = viewmodel.number.value.toString()*/

        //変更のあったnewNumberを表示
        viewmodel.numberGet().observe(this , Observer { newNumber ->
            number_textView.text = newNumber.toString()
        })

        number_button.setOnClickListener {
            //ボタンが押された時の処理
            viewmodel.addNumber()

            /*
            //ViewModelの追加されたnumberを表示
            number_textView.text = viewmodel.number.value.toString()*/

            viewmodel.numberGet().observe(this, Observer { newNumber ->
                number_textView.text = newNumber.toString()
            })

        }
    }
}