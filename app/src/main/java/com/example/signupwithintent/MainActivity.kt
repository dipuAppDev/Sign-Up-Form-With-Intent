package com.example.signupwithintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var profileImage:ShapeableImageView
    private lateinit var cameraImage:ImageView
    private lateinit var userName:TextInputEditText
    private lateinit var userEmail:TextInputEditText
    private lateinit var userPass:TextInputEditText
    private lateinit var userConPass:TextInputEditText
    private lateinit var userAge:TextInputEditText
    private lateinit var userAddress:TextInputEditText
    private lateinit var submitBtn: Button
    var uri: Uri?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileImage = findViewById(R.id.profileImage)
        cameraImage = findViewById(R.id.cameraImage)
        userName = findViewById(R.id.username)
        userEmail = findViewById(R.id.email)
        userPass = findViewById(R.id.password)
        userConPass = findViewById(R.id.conPassword)
        userAddress = findViewById(R.id.address)
        userAge = findViewById(R.id.age)
        submitBtn = findViewById(R.id.submitBtn)
        profileImage.setOnClickListener {
            pickImageFromGallery()
        }
        submitBtn.setOnClickListener {
            val userName = userName.text.toString()
            val userEmail = userEmail.text.toString()
            val userPass = userPass.text.toString()
            val userConPass = userConPass.text.toString()
            val userAge = userAge.text.toString()
            val userAddress = userAddress.text.toString()

            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("profileImage",uri)
            intent.putExtra("userName",userName)
            intent.putExtra("userEmail",userEmail)
            intent.putExtra("userPass",userPass)
            intent.putExtra("userConPass",userConPass)
            intent.putExtra("userAge",userAge)
            intent.putExtra("userAddress",userAddress)
            startActivity(intent)
        }







    }

    private fun pickImageFromGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && data!=null){
            uri = data.data
            profileImage.setImageURI(uri)
        }
    }
}