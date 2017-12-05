package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair

class CustomPokemon {

    var thumbnail: Bitmap? = null
    var name: String? = null
    var type: String? = null
    internal var mLearnedMoves: List<Move>? = null
    internal var mAbilities: List<Pair<String, String>>? = null

}
