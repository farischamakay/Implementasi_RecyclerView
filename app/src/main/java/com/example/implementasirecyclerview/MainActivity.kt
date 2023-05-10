package com.example.implementasirecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTruck : RecyclerView
    private val list = ArrayList<Truck>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.title = "Jenis-Jenis Truck"

        rvTruck = findViewById(R.id.rv_trucks)
        rvTruck.setHasFixedSize(true)

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
                rvTruck.layoutManager = GridLayoutManager(this, 2)
                return true
            }
            R.id.action_next -> {
                Toast.makeText(this,"Halo", Toast.LENGTH_SHORT).show()
                val pindah = Intent(this@MainActivity,DetailActivity::class.java)
                startActivity(pindah)
                return true
            }

            R.id.action_list -> {
                rvTruck.layoutManager = LinearLayoutManager(this)
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
        rvTruck.layoutManager = LinearLayoutManager(this)
        val listTruckAdapter = ListTruckAdapter(list)
        rvTruck.adapter = listTruckAdapter

        listTruckAdapter.setOnItemClickCallback(
            object : ListTruckAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Truck) {
                    showSelectedTruck(data)
                }
            }
        )


    }

    private fun showSelectedTruck(truck: Truck){
        Toast.makeText(this,"Kamu memilih " + truck.name, Toast.LENGTH_SHORT).show()

    }


}