package com.example.kotlinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinstagram.databinding.ActivityFeedBinding
import com.example.kotlinstagram.databinding.ActivityMainBinding

class FeedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}