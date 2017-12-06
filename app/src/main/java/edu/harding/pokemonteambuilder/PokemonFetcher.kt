package edu.harding.pokemonteambuilder

import android.util.Log
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*
import java.util.*

class PokemonFetcher {
    private var mPokeApi: PokeApi = PokeApiClient()

    fun fetchPokemon(pokedexIndex: Int): Pokemon = mPokeApi.getPokemon(pokedexIndex)

    fun fetchAll() : ArrayList<Pokemon>{
        // Error 429 - Too many requests
        var totalPokemon: Int = mPokeApi.getPokemonList(0, 0).count
        Log.d("API", totalPokemon.toString())
        return (0..19).mapTo(ArrayList()) { fetchPokemon(it) }
    }
}
