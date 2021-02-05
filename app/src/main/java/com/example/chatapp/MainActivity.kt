package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.firebase.database.DatabaseReference

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.RegisterActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        supportActionBar?.hide()

        loginButton = findViewById(R.id.home_loginButton)
        registerButton = findViewById(R.id.home_registerButton)

        loginButton.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java ))
        }

        registerButton.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java ))
        }

//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment)
//
//        val appConfig = AppBarConfiguration(setOf(
//            R.id.navigation_home, R.id.navigation_register, R.id.navigation_Login, R.id.navigation_chat
//
//
//        ))
//
//
//        setupActionBarWithNavController(navController, appConfig)
//        navView.setupWithNavController(navController)


    }
}