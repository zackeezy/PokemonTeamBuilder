package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair
import me.sargunvohra.lib.pokekotlin.model.Pokemon

class CustomPokemon(name: String, type: String) {

    var name: String? = null
    var type: String? = null
    var thumbnail: Bitmap? = null
    internal var mLearnedMoves: List<Move>? = null
    internal var mAbilities: List<Pair<String, String>>? = null

    // Kotlin equivalent to static function
    companion object {
        fun pokemonToCustomPokemon(p: Pokemon): CustomPokemon {
            var c: CustomPokemon = CustomPokemon("", "")

            if (p.types.size == 2) {
                c.type = p.types[0].toString() + "/" + p.types[1].toString()
            } else {
                c.type = p.types[0].toString()
            }

            c.name = p.name

            //add more code for more things as we need them

            return c
        }
    }

    init {
        this.name = name
        this.type = type
    }
}
