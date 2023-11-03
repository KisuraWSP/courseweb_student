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
import com.example.courseweb_student.database.entity.User
import com.example.courseweb_student.database.repository.UserRepository
import com.example.courseweb_student.view.UserViewModelFactory

class CreateUserActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        val userDatabase = UserDatabase.invoke(applicationContext)
        userRepository = UserRepository(userDatabase)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository)).get(UserViewModel::class.java)

        val usernameEditText: EditText = findViewById(R.id.username_textField)
        val passwordEditText: EditText = findViewById(R.id.password_textField)
        val reEnterPasswordEditText: EditText = findViewById(R.id.reEnter_password_textField)
        val submitButton: Button = findViewById(R.id.submit_btn)

        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val reEnterPassword = reEnterPasswordEditText.text.toString().trim()

            if (password == reEnterPassword) {
                val user = User(username, password)
                userViewModel.insert(user)
                Toast.makeText(this,"User Successfully Created!!!",Toast.LENGTH_SHORT).show()

                val main_intent = Intent(this, MainActivity::class.java)
                startActivity(main_intent)
            } else {
                Toast.makeText(this,"Passwords Don't Match!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
