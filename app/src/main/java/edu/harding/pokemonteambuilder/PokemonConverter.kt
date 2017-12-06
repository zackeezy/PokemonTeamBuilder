package edu.harding.pokemonteambuilder

import me.sargunvohra.lib.pokekotlin.model.Pokemon
import me.sargunvohra.lib.pokekotlin.model.PokemonType
import java.util.*

/**
 * Created by Bryan Cuneo on 12/06/17.
 */
class PokemonConverter {
    fun customPokemonFromAPI(p: Pokemon): CustomPokemon {
        var newCustomPokemon = CustomPokemon()
        newCustomPokemon.name = p.name
        for (t: PokemonType in p.types)
            newCustomPokemon.types.add(t.type.name)

        return newCustomPokemon
    }

    fun customPokemonListFromAPI(l: ArrayList<Pokemon>): ArrayList<CustomPokemon> {
        var newCustomPokemonList: ArrayList<CustomPokemon> = ArrayList()
        for (p in l)
            newCustomPokemonList.add(customPokemonFromAPI(p))

        return newCustomPokemonList
    }
}