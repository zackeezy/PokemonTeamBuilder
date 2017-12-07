package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_trainer_card.*
import java.util.*
import android.provider.MediaStore
import android.content.Intent
import android.R.attr.data
import android.app.Activity
import android.support.v4.app.NotificationCompat.getExtras





class TrainerCardActivity : AppCompatActivity() {
    var mTemplates = ArrayList<Bitmap>()

    val REQUEST_IMAGE_CAPTURE: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_card)

        setupActionBar()

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

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Pokemon Team Builder"
        setSupportActionBar(ab)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun launchCamera(view: View){
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    fun generateTrainerCard(view: View){

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode === REQUEST_IMAGE_CAPTURE && resultCode === Activity.RESULT_OK) {
            val extras = data!!.getExtras()
            val imageBitmap = extras.get("data") as Bitmap
            userPhotoImageView.setImageBitmap(imageBitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
