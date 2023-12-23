package com.example.signupwithintent

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class HomeActivity : AppCompatActivity() {
    private lateinit var profileImage:ImageView
    private lateinit var userName:TextView
    private lateinit var userEmail:TextView
    private lateinit var userPass:TextView
    private lateinit var userConPass:TextView
    private lateinit var userAge:TextView
    private lateinit var userAddress:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        profileImage = findViewById(R.id.imageH)
        userName = findViewById(R.id.nameH)
        userEmail = findViewById(R.id.emailH)
        userPass = findViewById(R.id.passwordH)
        userConPass = findViewById(R.id.conPassH)
        userAge = findViewById(R.id.ageH)
        userAddress = findViewById(R.id.addressH)


       profileImage.setImageURI(intent.getParcelableExtra("profileImage") as Uri?)
        userName.text = intent.getStringExtra("userName").toString()
        userEmail.text = intent.getStringExtra("userEmail").toString()
        userPass.text = intent.getStringExtra("userPass").toString()
        userConPass.text = intent.getStringExtra("userConPass").toString()
        userAddress.text = intent.getStringExtra("userAddress").toString()
        userConPass.text = intent.getStringExtra("userConPass").toString()
        userAge.text = intent.getStringExtra("userAge").toString()












    }
}