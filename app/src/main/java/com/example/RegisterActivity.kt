package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chatapp.LoginActivity
import com.example.chatapp.R
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {


    private lateinit var inPutName: EditText
    private lateinit var inPutEmail: EditText
    private lateinit var inPutPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()


        inPutName = findViewById(R.id.register_username)
        inPutEmail = findViewById(R.id.register_email)
        inPutPassword = findViewById(R.id.register_password)
        registerButton = findViewById(R.id.register_registerButton)

        registerButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

            val email = inPutEmail.text.toString()
            val password = inPutPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText( this,"Please enter again", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {task->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }else {
                            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                        }

                }
        }




    }
}}