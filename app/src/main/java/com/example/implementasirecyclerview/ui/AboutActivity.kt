package com.example.implementasirecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.implementasirecyclerview.R
import com.example.implementasirecyclerview.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"


        Glide.with(this)
            .load(R.drawable.truktanpamuatan)
            .apply(RequestOptions().transform(CircleCrop()))
            .into(binding.imageView)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Menangani ketika tombol back ditekan
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}