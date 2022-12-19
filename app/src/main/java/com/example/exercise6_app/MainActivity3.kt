package com.example.exercise6_app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    lateinit var drinkGroup: RadioGroup
    lateinit var sugarGroup: RadioGroup
    lateinit var iceGroup: RadioGroup
    lateinit var ice: RadioButton
    lateinit var sugar: RadioButton
    lateinit var selectedDrink: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var tv_table3 = findViewById<TextView>(R.id.tv_table3)
        var btn_orderConfirm2 = findViewById<Button>(R.id.btn_orderConfirm2)

        //輸入飲料名稱
        //綁定單選清單群
        drinkGroup = findViewById(R.id.RadioGroup1)
        sugarGroup = findViewById(R.id.RadioGroup2)
        iceGroup = findViewById(R.id.RadioGroup3)

        //接收並顯示由主頁intent傳來之桌次
        tv_table3.text = intent.getStringExtra("dataTransfer")

        btn_orderConfirm2.setOnClickListener {
            //由單選清單radioGroup取得選項id，!!表不可為null
            var selectedOption: Int = iceGroup!!.checkedRadioButtonId
            //由選項id取得冰量
            ice = findViewById(selectedOption)

            //由選項id取得甜度
            selectedOption = sugarGroup!!.checkedRadioButtonId
            sugar = findViewById(selectedOption)

            //由選項id取得選取之飲料別
            selectedOption = drinkGroup!!.checkedRadioButtonId
            selectedDrink = findViewById(selectedOption)

            val finalDrink = "${selectedDrink.text} \n\n甜度：${sugar.text} \n\n冰塊：${ice.text}"
            val intent = Intent().apply {
                putExtra("result","${finalDrink}")
            }

            //透過setResult將資料回傳
            setResult(Activity.RESULT_OK, intent)
            //結束MainActivity3
            finish()
        }
    }
}