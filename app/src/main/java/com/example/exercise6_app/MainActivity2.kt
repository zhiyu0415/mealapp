package com.example.exercise6_app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var btn_orderConfirm = findViewById<Button>(R.id.btn_orderConfirm)
        var tv_table2 = findViewById<TextView>(R.id.tv_table2)

        //接收並顯示由主頁intent傳來之桌次
        tv_table2.text = intent.getStringExtra("dataTransfer")

        //點餐
        btn_orderConfirm.setOnClickListener {
            //將主餐名稱放入Bundle
            lateinit var mealA: CheckBox
            lateinit var mealB: CheckBox
            lateinit var mealC: CheckBox
            lateinit var mealD: CheckBox
            mealA = findViewById(R.id.checkBox_A)
            mealB = findViewById(R.id.checkBox_B)
            mealC = findViewById(R.id.checkBox_C)
            mealD = findViewById(R.id.checkBox_D)

            var meal1 = if (mealA.isChecked) "A餐" else ""
            var meal2 = if (mealB.isChecked) "B餐" else ""
            var meal3 = if (mealC.isChecked) "C餐" else ""
            var meal4 = if (mealD.isChecked) "D餐" else ""
            val meal = "$meal1 $meal2 $meal3 $meal4"

            val intent = Intent().apply {
                putExtra("result", "$meal")
            }

            //透過setResult將資料回傳
            setResult(Activity.RESULT_OK, intent)

            //結束MainActivity2
            finish()

        }
    }
}