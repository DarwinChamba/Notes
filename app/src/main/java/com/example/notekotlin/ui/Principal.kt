package com.example.notekotlin.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.notekotlin.R
import com.example.notekotlin.databinding.ActivityPrincipalBinding
import com.example.notekotlin.viewmodel.NotasViewModel

class Principal : AppCompatActivity() {
    private lateinit var modelo:NotasViewModel
    private lateinit var binding:ActivityPrincipalBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modelo=ViewModelProvider(this).get(NotasViewModel::class.java)
        //setSupportActionBar(binding.toolBar)
        cambiarColor()

    }

    private fun cambiarColor(){
        val window=this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor=getColor(R.color.colorPrincipal)
    }


}