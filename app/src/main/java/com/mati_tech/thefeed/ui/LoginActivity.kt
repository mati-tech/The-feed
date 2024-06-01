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
import com.google.firebase.auth.FirebaseAuth
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.ui.Viewmodels.AuthenticationViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var authViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        emailEditText = findViewById(R.id.username_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        // Initialize AuthenticationViewModel
        authViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate email and password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call signIn function from AuthenticationViewModel
            (authViewModel as AuthenticationViewModel).login(email, password) { signInSuccess ->
                if (signInSuccess) {
                    // Sign-in successful, navigate to MainActivity
                    val intent = Intent(this@LoginActivity, NewsActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Handle sign-in failure
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<TextView>(R.id.register_text_view).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, NewsActivity::class.java))
            finish()
        }
    }
}
