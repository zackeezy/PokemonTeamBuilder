package edu.harding.pokemonteambuilder

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import java.util.*

class MainActivity : AppCompatActivity() {
    var mTeam: PokemonTeam = PokemonTeam()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pokemonChoose(view: View) {
        when(view.tag){
            R.string.pokemon_1 -> {
                mTeam.mPokemon1 = CustomPokemon()

            }
            R.string.pokemon_2 -> {
                mTeam.mPokemon2 = CustomPokemon()

            }
            R.string.pokemon_3 -> {
                mTeam.mPokemon3 = CustomPokemon()

            }
            R.string.pokemon_4 -> {
                mTeam.mPokemon4 = CustomPokemon()

            }
            R.string.pokemon_5 -> {
                mTeam.mPokemon5 = CustomPokemon()

            }
            R.string.pokemon_6 -> {
                mTeam.mPokemon6 = CustomPokemon()

            }
        }
    }

    fun buildTrainerCard(view: View) {
        var intent = Intent(this, TrainerCardActivity::class.java)

        startActivity(intent)
    }

    fun tryBuildDB(view: View) {
        var api = PokemonFetcher()
        var db = PokemonDatabase(getPreferences(Context.MODE_PRIVATE))
        var pokemonList: ArrayList<CustomPokemon>
        var converter = PokemonConverter()
        doAsync {
            pokemonList = converter.customPokemonListFromAPI(api.fetchAll())
            db.save(pokemonList)
        }
    }

    fun tryLoadDB(view: View) {
        var db = PokemonDatabase(getPreferences(Context.MODE_PRIVATE))
        var pokemonList = db.load()
        Log.d("DB", pokemonList.toString())
    }

    fun goToList(view: View) {
        val intent = Intent(this, PokemonListActivity::class.java)
        startActivity(intent)
    }
}
