package com.example.implementasirecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTruck : RecyclerView
    private val list = ArrayList<Truck>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTruck = findViewById(R.id.rv_trucks)
        rvTruck.setHasFixedSize(true)

        list.addAll(getListTruck())
        showRecycleView()
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