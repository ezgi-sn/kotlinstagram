package com.example.kotlinstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinstagram.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth
        signUp()
    }

    fun signUp(){
        val button = binding.signUpButton
        button.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            if(email.equals("") && password.equals("")){
                Toast.makeText(this,"Enter email and password!", Toast.LENGTH_LONG).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this,"Enter email and password!", Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}