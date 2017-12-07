package edu.harding.pokemonteambuilder

import java.io.Serializable

class PokemonTeam : Serializable{
    var mPokemon1: CustomPokemon? = null
    var mPokemon2: CustomPokemon? = null
    var mPokemon3: CustomPokemon? = null
    var mPokemon4: CustomPokemon? = null
    var mPokemon5: CustomPokemon? = null
    var mPokemon6: CustomPokemon? = null

    fun isValid(): Boolean = (mPokemon1 != null || mPokemon2 != null || mPokemon3 != null || mPokemon4 != null || mPokemon5 != null || mPokemon6 != null)
}