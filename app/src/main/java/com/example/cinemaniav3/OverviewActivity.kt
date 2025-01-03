package com.example.cinemaniav3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import  androidx.appcompat.widget.Toolbar
import com.example.cinemaniav3.databinding.ActivityMainBinding
import com.example.cinemaniav3.databinding.ActivityOverviewBinding

class OverviewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Movie Overview"
        // Handle the back button
        toolbar.setNavigationOnClickListener { onBackPressed() }

        val title = intent.getStringExtra("title")
        val summary = intent.getStringExtra("summary")
        val posterPath = intent.getStringExtra("poster_path")

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$posterPath")
            .into(binding.overviewImage)

        binding.overviewTitle.text = title
        binding.overviewSummary.text = summary

    }
}