package edu.harding.pokemonteambuilder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PokemonListActivity : AppCompatActivity() {

    var mFetcher: PokemonFetcher = PokemonFetcher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)


    }
}
