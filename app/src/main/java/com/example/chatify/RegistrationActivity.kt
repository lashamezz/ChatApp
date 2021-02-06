package com.example.chatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var registerUserEmail: EditText
    private lateinit var registerPassword: EditText
    private lateinit var checkPass: EditText
    private lateinit var registerUserButton: Button
    private lateinit var signupRegister: Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()

        registerUserEmail = findViewById(R.id.regActivityMail)
        registerPassword = findViewById(R.id.registerPasswordEdit)
        registerUserButton=findViewById(R.id.profileRegisterButton)
//        signupRegister=findViewById(R.id.profileSignUpButton)

        registerUserButton.setOnClickListener {
            val email = registerUserEmail.text.toString()
            val pass = registerPassword.text.toString()
            val checkedPass = checkPass.text.toString()
            if(email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Empty", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }
//        signupRegister.setOnClickListener {
//            startActivity(Intent(this,MainActivity::class.java))
//        }
    }
}