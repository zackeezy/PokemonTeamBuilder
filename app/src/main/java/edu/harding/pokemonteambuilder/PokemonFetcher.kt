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
        // TODO: Use getPokemonList(offset, limit) and increment instead of individual individual request
        var offset = 0
        var limit = 20
        var segment: NamedApiResourceList
        var count: Int

        try {
            segment = mPokeApi.getPokemonList(offset, limit)
            count = segment.count
            Log.d("API", count.toString())
        } catch (e: Exception) { count = 949}

        var pokemonList = ArrayList<Pokemon>()
        for (i: Int in 1..count) {
            try {
                Thread.sleep(1000)
                 pokemonList.add(fetchPokemon(i))
                Log.d("API", "Fetching $i")
            } catch (e: Exception) { Log.d("API ERROR", e.toString()); break }
        }

        return pokemonList

        //return (1..count).mapTo(ArrayList()) { fetchPokemon(it)}
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
