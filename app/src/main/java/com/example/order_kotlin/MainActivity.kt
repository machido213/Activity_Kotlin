package com.example.order_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_ch =findViewById<Button>(R.id.btn_choice)
        btn_ch.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java)
            startActivityForResult(intent,1)
        }
    }
    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data==null)return
        if(requestCode==1){
            if(resultCode==101){
                val b=data.getBundleExtra("textbun")
                val drink=b?.getString("drink")
                val ice=b?.getString("ice")
                val sugar=b?.getString("sugar")
                val tv_meal=findViewById<TextView>(R.id.tv_meal)
                tv_meal.setText("飲料："+drink+"\n\n冰塊："+ice+"\n\n甜度："+sugar)
            }
        }
    }
}