import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.courseweb_student.CreateUserActivity
import com.example.courseweb_student.MainActivity
import com.example.courseweb_student.R
import com.example.courseweb_student.database.UserDatabase
import com.example.courseweb_student.database.repository.UserRepository
import com.example.courseweb_student.view.UserViewModelFactory
class LoginActivity : AppCompatActivity() {

    private lateinit var login_btn: Button
    private lateinit var create_user_btn: Button
    private lateinit var username_field: EditText
    private lateinit var password_field: EditText

    private lateinit var userRepository: UserRepository
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn = findViewById(R.id.login_btn)
        create_user_btn = findViewById(R.id.create_user_btn)
        username_field = findViewById(R.id.login_userName_field)
        password_field = findViewById(R.id.login_password_field)

        // Initialize UserRepository and UserViewModel
        val userDatabase = UserDatabase.invoke(applicationContext)
        userRepository = UserRepository(userDatabase)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userRepository)).get(
            UserViewModel::class.java)

        login_btn.setOnClickListener {
            login()
        }
        create_user_btn.setOnClickListener {
            val create_user_intent = Intent(this, CreateUserActivity::class.java)
            startActivity(create_user_intent)
        }
    }

    private fun login() {
        val userName = username_field.text.toString()
        val password = password_field.text.toString()

        if (userName.isNotEmpty() && password.isNotEmpty()) {
            // Check the entered credentials against the database
            userViewModel.getUserByName(userName).observe(this, { user ->
                if (user != null && user.password == password) {
                    // Login successful
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    val main_intent = Intent(this, MainActivity::class.java)
                    startActivity(main_intent)
                    finish() // Optional: Finish the LoginActivity
                } else {
                    // Invalid credentials
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            // Empty username or password
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
        }
    }
}
