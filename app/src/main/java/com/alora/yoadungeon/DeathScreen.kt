package com.alora.yoadungeon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeathScreen : AppCompatActivity() {
    internal lateinit var returnToGame: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_death_screen)

        returnToGame = findViewById(R.id.returnToGame)

        returnToGame.setOnClickListener {
            val intent = Intent(this@DeathScreen, dungeonCrawler::class.java)
            startActivity(intent)
            finish()
        }

    }
}