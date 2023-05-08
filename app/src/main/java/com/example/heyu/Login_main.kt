package com.example.heyu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.heyu.databinding.ActivityLoginMainBinding
import com.google.firebase.auth.FirebaseAuth

class Login_main : AppCompatActivity() {

    private lateinit var binding:ActivityLoginMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener{
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.btnlogin.setOnClickListener{

            val email = binding.etemailaddress.text.toString()
            val pass = binding.etpaasswrd.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() ){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this,Homeactivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Empty Field are not allowed!!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}