package edu.harding.pokemonteambuilder

import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*

class PokemonFetcher {
    internal var mPokeApi: PokeApi = PokeApiClient()

    fun fetchSpecies(species: Int): PokemonSpecies {
        return mPokeApi.getPokemonSpecies(species)
    }
}
