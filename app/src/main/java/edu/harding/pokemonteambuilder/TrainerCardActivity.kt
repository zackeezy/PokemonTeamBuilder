package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_trainer_card.*
import java.util.*

class TrainerCardActivity : AppCompatActivity() {
    var mTemplates = ArrayList<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_card)

        var groudon = BitmapFactory.decodeResource(resources, R.drawable.groudon)
        var kyogre = BitmapFactory.decodeResource(resources, R.drawable.kyogre)
        var xerneas = BitmapFactory.decodeResource(resources, R.drawable.xerneas)
        var yveltal = BitmapFactory.decodeResource(resources, R.drawable.yveltal)
        var chesnaught = BitmapFactory.decodeResource(resources, R.drawable.chesnaught)
        var delphox = BitmapFactory.decodeResource(resources, R.drawable.delphox)
        var greninja = BitmapFactory.decodeResource(resources, R.drawable.greninja)
        var lunala = BitmapFactory.decodeResource(resources, R.drawable.moon)
        var solgaleo = BitmapFactory.decodeResource(resources, R.drawable.sun)
        var instinct = BitmapFactory.decodeResource(resources, R.drawable.instinct)
        var mystic = BitmapFactory.decodeResource(resources, R.drawable.mystic)
        var valor = BitmapFactory.decodeResource(resources, R.drawable.valor)

        mTemplates.add(groudon)
        mTemplates.add(kyogre)
        mTemplates.add(xerneas)
        mTemplates.add(yveltal)
        mTemplates.add(chesnaught)
        mTemplates.add(delphox)
        mTemplates.add(greninja)
        mTemplates.add(lunala)
        mTemplates.add(solgaleo)
        mTemplates.add(instinct)
        mTemplates.add(mystic)
        mTemplates.add(valor)

        var adapter = ArrayAdapter.createFromResource(this, R.array.trainer_card_types, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        trainerCardTypeSpinner.adapter = adapter
    }

    fun launchCamera(view: View){

    }

    fun generateTrainerCard(view: View){

    }
}
