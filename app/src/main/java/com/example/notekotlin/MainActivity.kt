package com.example.notekotlin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.notekotlin.ui.Principal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cambiarColor()
        irActividad()
    }
    fun irActividad(){
        val handler= Handler().postDelayed({
            val intent=Intent(this,Principal::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
    fun cambiarColor(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            val window=this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor=resources.getColor(R.color.white)
        }
    }
}