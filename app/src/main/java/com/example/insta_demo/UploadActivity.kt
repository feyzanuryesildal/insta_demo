package com.example.insta_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.insta_demo.databinding.ActivityMainBinding
import com.example.insta_demo.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        val view =  binding.root
        setContentView(view)
    }

    fun Upload(view: View){

    }

    fun selectImage(view: View){

    }
}