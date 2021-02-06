package com.example.chatify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chatify.Fragments.FragmentProfile
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var loginUserMail: EditText
    private lateinit var userPassword: EditText
    private lateinit var userInButton: Button
    private lateinit var userUpButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        loginUserMail = findViewById(R.id.regActivityMail)
        userPassword=findViewById(R.id.registerPasswordEdit)
        userInButton=findViewById(R.id.signupButton)
        userUpButton=findViewById(R.id.profileSignUpButton)

        userInButton.setOnClickListener {
            val email = loginUserMail.text.toString()
            val password = userPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()

            }else{

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        startActivity(Intent(this, NavigationActivity::class.java))
                        finish()

                    }else{

                        Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()

                    }

                }
            }

        }
        userUpButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }



    }
}