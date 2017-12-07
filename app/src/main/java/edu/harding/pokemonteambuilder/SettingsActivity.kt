package edu.harding.pokemonteambuilder

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupActionBar()
    }

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Settings"
        setSupportActionBar(ab)
    }

    fun updateDatabase_onClick(view: View) {
        alert("This will take several minutes") {
            title="Warning"
            yesButton { toast("Updating DB..."); updateDatabase() }
            noButton { }
        }.show()
    }

    fun updateDatabase() {
        val converter = PokemonConverter()
        val db = PokemonDatabase(getPreferences(Context.MODE_PRIVATE))
        val fetcher = PokemonFetcher()

        doAsync {
            try {
                db.save(converter.customPokemonListFromAPI(fetcher.fetchAll()))
                uiThread {
                    toast("Database update complete")
                }
            } catch (e: Exception) { toast("Database update failed") }
        }
    }
}
