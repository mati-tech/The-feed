package com.mati_tech.thefeed.ui.Viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.initialize

class AuthenticationViewModel (): ViewModel() {
//    private lateinit var auth: FirebaseAuth
    private val auth = FirebaseAuth.getInstance()

    // Function to handle user login with Firebase
    fun login(email: String, password: String, onLoginComplete: (Boolean) -> Unit) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onLoginComplete.invoke(task.isSuccessful) // Pass login success status
            }
    }

    // Function to handle user registration with Firebase
    fun register(email: String, password: String, onRegisterComplete: (Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onRegisterComplete.invoke(task.isSuccessful) // Pass registration success status
            }
    }
}
