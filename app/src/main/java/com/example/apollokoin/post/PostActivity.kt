package com.example.apollokoin.post

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apollokoin.R

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
