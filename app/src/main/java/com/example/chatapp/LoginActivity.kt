package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fragments.ChatFragment
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var inPutEmail: EditText
    private lateinit var inPutPassword: EditText
    private lateinit var loginButton: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()


        inPutEmail = findViewById(R.id.login_email)
        inPutPassword= findViewById(R.id.login_password)
        loginButton = findViewById(R.id.login_button)




        loginButton.setOnClickListener {
            val email = inPutEmail.text.toString()
            val password = inPutPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText( this,"Please enter again", Toast.LENGTH_SHORT).show()
            } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                task-> if (task.isSuccessful) {
                startActivity(Intent(this,MainActivity::class.java ))
                finish()

                }else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
            }

        }

        }
    }
}