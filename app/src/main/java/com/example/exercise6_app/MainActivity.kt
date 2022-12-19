package com.example.exercise6_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_meal = findViewById<Button>(R.id.btn_meal)
        var btn_drink = findViewById<Button>(R.id.btn_drink)
        var btn_reorder = findViewById<Button>(R.id.btn_reorder)
        var tv_finalDrink = findViewById<TextView>(R.id.tv_finalDrink)
        var tv_finalMeal = findViewById<TextView>(R.id.tv_finalMeal)
        var ed_tableNo = findViewById<EditText>(R.id.ed_tableNo)
        var txtTableNo = ed_tableNo.text

        //至協議2註冊，取得回傳主餐名稱，及第2頁啟動器launch
        var myActivityLauncher2 = registerForActivityResult(MyActivityResultContract2()){result ->
            tv_finalMeal.text = "主餐：$result"
        }

        //至協議3註冊，取得回傳飲料名稱，及第3頁啟動器launch
        var myActivityLauncher3 = registerForActivityResult(MyActivityResultContract3()){result ->
            tv_finalDrink.text = "飲料：$result"
        }

        //點按主餐
        btn_meal.setOnClickListener {
            //判斷是否輸入桌次
            if (ed_tableNo.length()<1)
                ed_tableNo.hint = "請輸入桌號！"
            else {
                //跳轉至主餐頁，並傳送桌號
                myActivityLauncher2.launch("$txtTableNo")
            }
        }

        //點按飲料
        btn_drink.setOnClickListener {
            if (ed_tableNo.length()<1)
                ed_tableNo.hint = "請輸入桌號！"
            else {
                //跳轉至飲料頁，並傳送桌號
                myActivityLauncher3.launch("$txtTableNo")
            }
        }

        //reStart app
        btn_reorder.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }

    }
}