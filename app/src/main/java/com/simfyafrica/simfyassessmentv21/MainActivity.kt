package com.simfyafrica.simfyassessmentv21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simfyafrica.simfyassessmentv21.adapter.PhotoAdapter
import com.simfyafrica.simfyassessmentv21.viewmodel.WebServiceViewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var webServiceViewModel: WebServiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webServiceViewModel = ViewModelProviders.of(this).get(WebServiceViewModel::class.java)

        webServiceViewModel.fetchCatImages()

        webServiceViewModel.catImagesLiveData.observe(this, Observer {
            val s = it.size
            if(s == 0){
                Toast.makeText(this, "Ha hona niks", Toast.LENGTH_LONG).show()
            }
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PhotoAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
