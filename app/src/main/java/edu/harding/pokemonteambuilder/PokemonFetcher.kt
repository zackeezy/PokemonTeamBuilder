package edu.harding.pokemonteambuilder

import android.util.Log
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*
import java.security.KeyStore
import java.util.*

class PokemonFetcher {


    private var mPokeApi: PokeApi


    init {
        mPokeApi = PokeApiClient()
    }


    fun fetchPokemon(pokedexIndex: Int) : Pokemon {
        var p: Pokemon
        try {
            p = mPokeApi.getPokemon(pokedexIndex)
        } catch (e: Exception) { throw e }

        return p
    }

    fun fetchAll() : ArrayList<Pokemon>{
        var pokemonList = ArrayList<Pokemon>()
        // >= 803 returns a 404
        for (i: Int in 1..802) {
            try {
                Thread.sleep(500)
                 pokemonList.add(fetchPokemon(i))
                Log.d("API", "Fetching $i")
            } catch (e: Exception) { Log.d("API ERROR", e.toString()); break }
        }

        return pokemonList
    }


    fun getPokemon() : ArrayList<CustomPokemon> {
        var pokemonList: ArrayList<CustomPokemon> = ArrayList()
        var pokemon: CustomPokemon = CustomPokemon()

        pokemon.name = "Bulbasaur"
        pokemon.types.add("Grass")
        pokemon.types.add("Poison")
        for(i: Int in 1..20)
            pokemonList.add(pokemon)

        return pokemonList
    }
}
