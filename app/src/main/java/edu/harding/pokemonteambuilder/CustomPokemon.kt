package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair
import java.util.*

class CustomPokemon() {

    var name: String
    var types: ArrayList<String>
    var thumbnail: Bitmap? = null
    internal var mLearnedMoves: ArrayList<Move>
    internal var mAbilities: ArrayList<Pair<String, String>>

    init {
        this.name = ""
        this.types = ArrayList()
        this.mLearnedMoves = ArrayList()
        this.mAbilities = ArrayList()
    }
}
