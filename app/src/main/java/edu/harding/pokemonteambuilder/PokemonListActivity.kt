package edu.harding.pokemonteambuilder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import layout.PokemonListFragment
import java.util.*

class PokemonListActivity : AppCompatActivity() {

    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        var fragmentManager: FragmentManager = supportFragmentManager
        mFragment = fragmentManager.findFragmentById(R.id.pokemon_list_container)

        if (mFragment == null) {
            mFragment = PokemonListFragment(this)
            fragmentManager.beginTransaction()
                    .add(R.id.pokemon_list_container, mFragment)
                    .commit()
        }
    }
}
