package com.mati_tech.thefeed.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.ui.Viewmodels.AuthenticationViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var regButton: Button
    private lateinit var goBack: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var authViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        FirebaseApp.initializeApp(this);
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text)
        regButton = findViewById(R.id.register_button)
        goBack = findViewById(R.id.Go_back_login)

        auth = Firebase.auth
        // Initialize AuthenticationViewModel
        authViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]

        regButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // Validate email, password, and confirm password
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please enter your email, password, and confirm password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (confirmPassword != password) {
                Toast.makeText(this, "Password and confirm password do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call register function from AuthenticationViewModel
            (authViewModel as AuthenticationViewModel).register(email, password) { registrationSuccess ->
                if (registrationSuccess) {
                    // Registration successful, navigate to Login activity
//                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
//                    startActivity(intent)
//                    finish()
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                } else {
                    // Handle registration failure
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

        }
        goBack.setOnClickListener{
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
