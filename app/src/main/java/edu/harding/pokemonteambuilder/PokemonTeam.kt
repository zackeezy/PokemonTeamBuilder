package edu.harding.pokemonteambuilder

import java.io.Serializable

class PokemonTeam : Serializable{
    var mPokemon1: String? = null
    var mPokemon2: String? = null
    var mPokemon3: String? = null
    var mPokemon4: String? = null
    var mPokemon5: String? = null
    var mPokemon6: String? = null

    fun isValid(): Boolean = (mPokemon1 != null || mPokemon2 != null || mPokemon3 != null || mPokemon4 != null || mPokemon5 != null || mPokemon6 != null)
}