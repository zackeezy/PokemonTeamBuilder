package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair

class CustomPokemon(name: String, type: String) {

    var name: String? = null
    var type: String? = null
    var thumbnail: Bitmap? = null
    internal var mLearnedMoves: List<Move>? = null
    internal var mAbilities: List<Pair<String, String>>? = null

    init {
        this.name = name
        this.type = type
    }
}
