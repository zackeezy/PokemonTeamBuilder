package edu.harding.pokemonteambuilder

import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*
import java.util.*

class PokemonFetcher {
    private var mPokeApi: PokeApi = PokeApiClient()

    fun fetchSpecies(pokedexIndex: Int): PokemonSpecies {
        return mPokeApi.getPokemonSpecies(pokedexIndex)
    }

    fun speciesToPokemon(species: PokemonSpecies): CustomPokemon {
        var pokemon = CustomPokemon()
        return pokemon
    }

    fun getPokemon() : ArrayList<CustomPokemon>{
        var pokemonList: ArrayList<CustomPokemon> = ArrayList()
        var pokemon: CustomPokemon = CustomPokemon()



    }
}
