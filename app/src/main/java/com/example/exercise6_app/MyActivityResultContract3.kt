package com.example.exercise6_app

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class MyActivityResultContract3: ActivityResultContract<String, String>() {
    //建構Intent及夾帶資料
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context,MainActivity3::class.java).apply {
            putExtra("dataTransfer",input)
        }
    }
    //接收回傳資料
    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val data = intent?.getStringExtra("result")
        return if (resultCode == Activity.RESULT_OK && data != null) data
        else ""
    }
}