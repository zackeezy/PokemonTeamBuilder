package edu.harding.pokemonteambuilder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar

class MoveSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_setup)

        setupActionBar()
    }

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Moves Setup"
    }
}
