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
import android.graphics.drawable.BitmapDrawable
import android.support.v4.app.NotificationCompat.getExtras
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import android.R.attr.bitmap
import java.io.*


class TrainerCardActivity : AppCompatActivity() {
    inner class BitmapSerializable : Serializable {
        private val serialVersionUID = -6298516694275121291L

        var bitmap: Bitmap? = null

        @Throws(IOException::class)
        private fun writeObject(oos: ObjectOutputStream) {
            // This will serialize all fields that you did not mark with 'transient'
            // (Java's default behaviour)
            oos.defaultWriteObject()
            // Now, manually serialize all transient fields that you want to be serialized
            if (bitmap != null) {
                val byteStream = ByteArrayOutputStream()
                val success = bitmap?.compress(Bitmap.CompressFormat.PNG, 100, byteStream)
                if (success == true) {
                    oos.writeObject(byteStream.toByteArray())
                }
            }
        }

        @Throws(IOException::class, ClassNotFoundException::class)
        private fun readObject(ois: ObjectInputStream) {
            // Now, all again, deserializing - in the SAME ORDER!
            // All non-transient fields
            ois.defaultReadObject()
            // All other fields that you serialized
            val image = ois.readObject() as ByteArray
            if (image != null && image.size > 0) {
                bitmap = BitmapFactory.decodeByteArray(image, 0, image.size)
            }
        }
    }

    var mSBitmap: BitmapSerializable? = null

    var mTemplates = ArrayList<Bitmap>()

    var mTeam: PokemonTeam = PokemonTeam()

    val REQUEST_IMAGE_CAPTURE: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_card)

        setupActionBar()

        var groudon = BitmapFactory.decodeResource(resources, R.drawable.card_groudon)
        var kyogre = BitmapFactory.decodeResource(resources, R.drawable.card_kyogre)
        var xerneas = BitmapFactory.decodeResource(resources, R.drawable.card_xerneas)
        var yveltal = BitmapFactory.decodeResource(resources, R.drawable.card_yveltal)
        var chesnaught = BitmapFactory.decodeResource(resources, R.drawable.card_chesnaught)
        var delphox = BitmapFactory.decodeResource(resources, R.drawable.card_delphox)
        var greninja = BitmapFactory.decodeResource(resources, R.drawable.card_greninja)
        var lunala = BitmapFactory.decodeResource(resources, R.drawable.card_moon)
        var solgaleo = BitmapFactory.decodeResource(resources, R.drawable.card_sun)

        mTemplates.add(groudon)
        mTemplates.add(kyogre)
        mTemplates.add(xerneas)
        mTemplates.add(yveltal)
        mTemplates.add(chesnaught)
        mTemplates.add(delphox)
        mTemplates.add(greninja)
        mTemplates.add(lunala)
        mTemplates.add(solgaleo)

        var adapter = ArrayAdapter.createFromResource(this, R.array.trainer_card_types, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        trainerCardTypeSpinner.adapter = adapter

        mTeam = intent.extras["Team"] as PokemonTeam
    }

    private fun setupActionBar() {
        var ab: Toolbar = findViewById(R.id.toolbar)
        ab.title = "Trainer Card"
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
        var i: Intent = Intent(this, TrainerCardDoneActivity::class.java)
        var options = resources.getStringArray(R.array.trainer_card_types)
        when(trainerCardTypeSpinner.selectedItem.toString()){
            options[0] ->{i.putExtra("Card", R.drawable.card_groudon)}
            options[1] ->{i.putExtra("Card", R.drawable.card_kyogre)}
            options[2] ->{i.putExtra("Card", R.drawable.card_xerneas)}
            options[3] ->{i.putExtra("Card", R.drawable.card_yveltal)}
            options[4] ->{i.putExtra("Card", R.drawable.card_chesnaught)}
            options[5] ->{i.putExtra("Card", R.drawable.card_delphox)}
            options[6] ->{i.putExtra("Card", R.drawable.card_greninja)}
            options[7] ->{i.putExtra("Card", R.drawable.card_moon)}
            options[8] ->{i.putExtra("Card", R.drawable.card_sun)}
        }
        i.putExtra("Team", mTeam)
        var bitmap = (userPhotoImageView.drawable as BitmapDrawable).bitmap
        var bStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream)
        i.putExtra("userImage",bStream.toByteArray())
        startActivity(i)
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
