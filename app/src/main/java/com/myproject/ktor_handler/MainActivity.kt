package com.myproject.ktor_handler

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        performKtorCrudOperations()
    }

    fun performKtorCrudOperations() {
        getAllPosts()
    }

    fun getAllPosts() {
        lifecycleScope.launch {
            ApiRepository().getPosts()
        }
    }
}