package com.example.prototypr_2_final.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prototypr_2_final.MainActivity
import com.example.prototypr_2_final.R

class On_Dead : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dead)

        var start_button = findViewById<Button>(R.id.button_play_choice1)
        start_button.setOnClickListener{
            var intent = Intent(this,game_storyScreen::class.java)
            startActivity(intent)
        }
        var btn_backToHome = findViewById<Button>(R.id.button_play_choice2)
        btn_backToHome.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}