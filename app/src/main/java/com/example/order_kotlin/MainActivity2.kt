package com.example.order_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var ice="正常冰"
        var drink=""
        var sugar="全糖"

        var ed_drink=findViewById<TextView>(R.id.ed_drink)
        var rg1=findViewById<RadioGroup>(R.id.radioGroup)
        var rg2=findViewById<RadioGroup>(R.id.radioGroup2)
        var btn_send=findViewById<Button>(R.id.btn_send)

        rg1.setOnCheckedChangeListener {_,i ->
            sugar=rg1.findViewById<RadioButton>(i).text.toString()
        }
        rg2.setOnCheckedChangeListener{ _,i ->
            ice=rg2.findViewById<RadioButton>(i).text.toString()
        }

        btn_send.setOnClickListener{
            drink=ed_drink.text.toString()
            val intent=Intent(this,MainActivity::class.java)
            val b=Bundle().apply{
                putString("drink",drink)
                putString("ice",ice)
                putString("sugar",sugar)
            }
            intent.putExtra("textbun",b)
            setResult(101,intent)
            finish()
        }
    }
}