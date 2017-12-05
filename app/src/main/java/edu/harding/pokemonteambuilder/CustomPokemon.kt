package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair

class CustomPokemon {

    fun CustomPokemon(name: String, type: String){
        this.name = name
        this.type = type
    }

    var thumbnail: Bitmap? = null
    var name: String? = null
    var type: String? = null
    internal var mLearnedMoves: List<Move>? = null
    internal var mAbilities: List<Pair<String, String>>? = null

}
