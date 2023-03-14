package com.example.prototypr_2_final.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prototypr_2_final.R

class game_storyScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_storyscreen)

        val storyGamemode = story_control(this)

        var btn_choice1 = findViewById<Button>(R.id.button_play_choice1)
        var btn_choice2 = findViewById<Button>(R.id.button_play_choice2)
        var btn_choice3 = findViewById<Button>(R.id.button_play_choice3)

        //way choice

        btn_choice1.setOnClickListener{
            storyGamemode.selectPosition(storyGamemode.nextPosition1)
        }
        btn_choice2.setOnClickListener{
            storyGamemode.selectPosition(storyGamemode.nextPosition2)
        }
        btn_choice3.setOnClickListener{
            storyGamemode.selectPosition(storyGamemode.nextPosition3)
        }
        storyGamemode.startingPoint()

    }

    fun goAtstart(){
        val StartScreen = Intent(this, On_Dead::class.java)
        startActivity(StartScreen)
    }


}