package com.example.implementasirecyclerview.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.implementasirecyclerview.data.Truck
import com.example.implementasirecyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val data = intent.getParcelableExtra<Truck>("DATA")
        Log.d("Detail Data", data?.name.toString())

        data?.photo?.let { binding.imgTruckDetail.setImageResource(it) }
        binding.tvNamaTruk.text = data?.name
        binding.tvDetailDescription.text = data?.description

        binding.fab.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Share konten")

            // Menampilkan dialog aplikasi yang tersedia untuk berbagi konten
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }

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