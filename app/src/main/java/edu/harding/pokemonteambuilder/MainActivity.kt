package edu.harding.pokemonteambuilder

import android.app.Activity
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
        var intent = Intent(this, PokemonListActivity::class.java)
        when(view.tag){
            R.string.pokemon_1 -> {
                intent.putExtra("pokemon", 1)
            }
            R.string.pokemon_2 -> {
                intent.putExtra("pokemon", 2)
            }
            R.string.pokemon_3 -> {
                intent.putExtra("pokemon", 3)
            }
            R.string.pokemon_4 -> {
                intent.putExtra("pokemon", 4)
            }
            R.string.pokemon_5 -> {
                intent.putExtra("pokemon", 5)
            }
            R.string.pokemon_6 -> {
                intent.putExtra("pokemon", 6)
            }
        }
        startActivityForResult(intent,0)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == 0){
            var pokemon: CustomPokemon = data!!.extras["Pokemon"] as CustomPokemon

        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
