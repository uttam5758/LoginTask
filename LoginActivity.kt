package com.example.mytask

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mytask.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences


    var username:String?=null
    var password:String?=null
    var Remember: Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)


        setContentView(loginBinding.root)


        loginBinding.button2.setOnClickListener {
            Log.d("Message","On resume call")
            sharedPreferences=getSharedPreferences("userdata", MODE_PRIVATE)
            username=sharedPreferences.getString("username","")
            password=sharedPreferences.getString("password","")

            if(username.toString() == loginBinding.Email1.text.toString()
                && password.toString() == loginBinding.password.text.toString()){
                val intent=Intent(this@LoginActivity,
                    DashboardActivity::class.java)


                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Invalid ",Toast.LENGTH_LONG).show()

            }




        }


        loginBinding.button2.setOnClickListener {

            sharedPreferences=getSharedPreferences("username", MODE_PRIVATE)
            username=loginBinding.Email1.text.toString()
            password=loginBinding.password.text.toString()

            var editor =sharedPreferences.edit()
            editor.putString("username",username)
            editor.putString("password",password)
            editor.putBoolean("Remember",true
            )

            editor.apply()

            Toast.makeText(applicationContext,"Data saved successfully", Toast.LENGTH_LONG).show()


        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkBox)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPause() {
        Log.d("Message","On pause call")
//        sharedPreferences=getSharedPreferences("username", MODE_PRIVATE)
//        username=loginBinding.textOne.text.toString()
//        password=loginBinding.textTwo.text.toString()
//
//        var editor =sharedPreferences.edit()
//        editor.putString("username",username)
//        editor.putString("password",password)
//
//        Toast.makeText(applicationContext,"Data saved", Toast.LENGTH_LONG).show()
//
//


        super.onPause()
    }

    override fun onResume() {

        super.onResume()
    }

}