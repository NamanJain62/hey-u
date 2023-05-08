package com.example.heyu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.heyu.databinding.ActivityLoginMainBinding
import com.example.heyu.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnsignup.setOnClickListener{
            val name = binding.etname.text.toString()
            val email = binding.etemailaddress.text.toString()
            val mobile = binding.etmobile.text.toString()
            val pass = binding.etpaasswrd.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && name.isNotEmpty() && mobile.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this,Login_main::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Empty Field are not allowed!!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}