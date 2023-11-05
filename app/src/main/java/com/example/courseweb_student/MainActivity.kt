package com.example.courseweb_student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var about_btn : Button
    private lateinit var profile_btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about_btn = findViewById(R.id.about_btn)
        profile_btn = findViewById(R.id.profile_btn)

        about_btn.setOnClickListener {
            var about_intent = Intent(this,AboutActivity::class.java)
            startActivity(about_intent)
        }

        profile_btn.setOnClickListener {
            var profile_intent = Intent(this, ProfileActivity::class.java)
            startActivity(profile_intent)
        }
    }
}