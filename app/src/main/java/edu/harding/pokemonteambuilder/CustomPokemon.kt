package edu.harding.pokemonteambuilder

import android.graphics.Bitmap
import android.util.Pair
import me.sargunvohra.lib.pokekotlin.model.Pokemon
import java.io.Serializable
import java.util.*

class CustomPokemon() : Serializable {

    var name: String? = null
    var types: ArrayList<String> = ArrayList()
    var thumbnail: Bitmap? = null
    internal var mLearnedMoves: ArrayList<Move> = ArrayList()
    internal var mAbilities: ArrayList<Pair<String, String>> = ArrayList()

    // Kotlin equivalent to static function
    companion object {
        fun pokemonToCustomPokemon(p: Pokemon): CustomPokemon {
            var c: CustomPokemon = CustomPokemon()

            if (p.types.size == 2) {
                //c.types = p.types[0].toString() + "/" + p.types[1].toString()
            } else {
                //c.types = p.types[0].toString()
            }

            c.name = p.name

            //add more code for more things as we need them

            return c
        }
    }

    constructor(name: String, types: ArrayList<String>) : this(){
        this.name = name
        this.types = types
    }

    constructor(name: String, types: ArrayList<String>, moves: ArrayList<Move>, abilities: ArrayList<Pair<String, String>>) : this(name, types) {
        this.mLearnedMoves = moves
        this.mAbilities = abilities
    }
}
