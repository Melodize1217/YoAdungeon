package com.alora.yoadungeon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alora.yoadungeon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding


    internal lateinit var beginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        beginButton = findViewById(R.id.beginButton)

        beginButton.setOnClickListener {
            val intent = Intent(this@MainActivity, dungeonCrawler::class.java)
            startActivity(intent)
            finish()
        }



    }
}