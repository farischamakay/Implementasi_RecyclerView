package com.example.implementasirecyclerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.implementasirecyclerview.adapter.ListTruckAdapter
import com.example.implementasirecyclerview.R
import com.example.implementasirecyclerview.data.Truck
import com.example.implementasirecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val list = ArrayList<Truck>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Jenis-Jenis Truck"

        binding.rvTrucks.setHasFixedSize(true)

        list.addAll(getListTruck())
        showRecycleView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_grid -> {
                // set layout manager ke GridLayout ketika menu Grid diklik
                binding.rvTrucks.layoutManager = GridLayoutManager(this, 2)
                return true
            }
            R.id.action_next -> {
                val pindah = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(pindah)
                return true
            }

            R.id.action_list -> {
                binding.rvTrucks.layoutManager = LinearLayoutManager(this)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun getListTruck(): ArrayList<Truck>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTruck = ArrayList<Truck>()
        for (i in dataName.indices){
            val truck = Truck(dataName[i],dataDescription[i], dataPhoto.getResourceId(i,-1))
            listTruck.add(truck)
        }
        return listTruck
    }


    private fun showRecycleView (){
        binding.rvTrucks.layoutManager = LinearLayoutManager(this)
        val listTruckAdapter = ListTruckAdapter(list)
        binding.rvTrucks.adapter = listTruckAdapter

        listTruckAdapter.setOnItemClickCallback(
            object : ListTruckAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Truck) {
                    val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                    intentToDetail.putExtra("DATA", data)
                    startActivity(intentToDetail)
                }
            }
        )


    }


}