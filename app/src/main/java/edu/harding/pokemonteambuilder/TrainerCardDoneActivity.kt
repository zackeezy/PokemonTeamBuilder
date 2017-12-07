package edu.harding.pokemonteambuilder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TrainerCardDoneActivity : AppCompatActivity() {

    var mTeam: PokemonTeam 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_card_done)


    }

    fun backToMainActivity(view: View){
        var i: Intent = Intent(applicationContext, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
    }
}
