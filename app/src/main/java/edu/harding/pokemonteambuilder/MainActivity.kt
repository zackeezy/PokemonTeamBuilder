package edu.harding.pokemonteambuilder

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import org.jetbrains.anko.doAsync
import java.util.*

class MainActivity : AppCompatActivity() {
    var mTeam: PokemonTeam = PokemonTeam()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflator = menuInflater
        inflator.inflate(R.menu.items, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        R.id.about_item -> {
            goToAboutActivity()
            true
        }
        R.id.settings_item -> {
            goToSettingsActivity()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
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


    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Pokemon Team Builder"
        setSupportActionBar(ab)
    }

    fun buildTrainerCard(view: View) {
        var intent = Intent(this, TrainerCardActivity::class.java)

        intent.putExtra("Team", mTeam)

        startActivity(intent)
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

    private fun goToAboutActivity() {
        var intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun goToSettingsActivity() {
        var intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == 0){
            var pokemon: CustomPokemon = data!!.extras["Pokemon"] as CustomPokemon
            var num: Int = data!!.extras["pokemon"] as Int
            
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
