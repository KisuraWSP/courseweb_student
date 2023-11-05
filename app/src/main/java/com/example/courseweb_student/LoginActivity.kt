package com.example.courseweb_student

import UserViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.courseweb_student.database.UserDatabase
import com.example.courseweb_student.database.repository.UserRepository
import com.example.courseweb_student.view.UserViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var login_btn : Button
    private lateinit var create_user_btn : Button
    private lateinit var username_tf : EditText
    private lateinit var password_tf : EditText

    private lateinit var userRepo : UserRepository
    private lateinit var userModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var userDB  = UserDatabase.invoke(applicationContext)
        userRepo = UserRepository(userDB)
        userModel = ViewModelProvider(this, UserViewModelFactory(userRepo))
            .get(UserViewModel::class.java)

        login_btn = findViewById(R.id.login_btn)
        create_user_btn = findViewById(R.id.create_user_btn)
        username_tf = findViewById(R.id.login_userName_field)
        password_tf = findViewById(R.id.login_password_field)

        login_btn.setOnClickListener{
            login()
        }

        create_user_btn.setOnClickListener {
            var create_user_intent = Intent(this,CreateUserActivity::class.java)
            startActivity(create_user_intent)
        }
    }

    private fun login(){
        val user_name = username_tf.text.toString()
        val password = password_tf.text.toString()

        if(user_name.isNotEmpty() && password.isNotEmpty()){
            userModel.getUserByName(user_name).observe(this) { user ->
                if (user != null && user.password == password) {
                    Toast.makeText(this, "Login Successful!!!", Toast.LENGTH_SHORT).show()
                    val main_intent = Intent(this, MainActivity::class.java)
                    startActivity(main_intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid Credentials!!!", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this,"Empty UserName or Password!!!",Toast.LENGTH_SHORT).show()
        }
    }
}