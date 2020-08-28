package com.example.pruebatecnica.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebatecnica.R
import com.example.pruebatecnica.view.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        view_pager.adapter = mainViewPagerAdapter

    }

}