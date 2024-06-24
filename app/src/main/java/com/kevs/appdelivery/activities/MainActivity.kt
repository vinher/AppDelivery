package com.kevs.appdelivery.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kevs.appdelivery.R
import com.kevs.appdelivery.activities.fragments.RegisterUser
import com.kevs.appdelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        _binding.registerId.setOnClickListener {
            registerUser()
        }


    }

    private fun registerUser() {
        /*val i = Intent(this,RegisterUser::class.java)
        startActivity(i)*/
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, RegisterUser())
            .commit()
    }
}