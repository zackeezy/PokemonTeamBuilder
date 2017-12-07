package edu.harding.pokemonteambuilder

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

class TrainerCardDoneActivity : AppCompatActivity() {

    var mTeam: PokemonTeam? = null

    var mUserImage: Bitmap? = null

    var mTemplate: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_card_done)

        setupActionBar()

        mTeam = intent.extras["Team"] as PokemonTeam

        mUserImage = (intent.extras["userImage"] as TrainerCardActivity.BitmapSerializable).bitmap

        mTemplate = (resources.getDrawable(intent.extras["Card"] as Int, null) as BitmapDrawable).bitmap

    }

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Trainer Card Done"
        setSupportActionBar(ab)
    }

    fun backToMainActivity(view: View){
        var i: Intent = Intent(applicationContext, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
    }
}
