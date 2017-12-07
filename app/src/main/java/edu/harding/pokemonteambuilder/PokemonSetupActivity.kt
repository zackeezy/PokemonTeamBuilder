package edu.harding.pokemonteambuilder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button

class PokemonSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_setup)

        setupActionBar()
    }

    fun chooseMove(view: View){
        when((view as Button).tag){
            R.string.move_1_tag -> {
                //TODO: make move setup activity
            }
            R.string.move_2_tag -> {

            }
            R.string.move_3_tag -> {

            }
            R.string.move_4_tag -> {

            }
        }
    }

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Pokemon Setup"
    }
}
