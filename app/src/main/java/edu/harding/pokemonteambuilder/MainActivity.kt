package edu.harding.pokemonteambuilder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import org.jetbrains.anko.doAsync
import java.io.Console

class MainActivity : AppCompatActivity() {
    //val api: PokemonFetcher = PokemonFetcher()
    val mPokeApi: PokeApi = PokeApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pokemonChoose(view: View) {

    }

    fun buildTrainerCard(view: View) {
        doAsync {
            Log.d("API", "starting...")
            var p: Pokemon = mPokeApi.getPokemon(1)
            Log.d("BULB", p.name)
            Log.d("BULB", p.types.toString())
            Log.d("BULB", p.moves.toString())
            Log.d("BULB", p.abilities.toString())
            Log.d("API", "done")
        }
    }
}
