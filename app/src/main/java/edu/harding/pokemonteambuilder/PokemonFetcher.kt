package edu.harding.pokemonteambuilder

import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*

class PokemonFetcher {
    private var mPokeApi: PokeApi = PokeApiClient()

    fun fetchSpecies(pokedexIndex: Int): PokemonSpecies {
        return mPokeApi.getPokemonSpecies(pokedexIndex)
    }

    fun speciesToPokemon(species: PokemonSpecies): CustomPokemon {
        var pokemon = CustomPokemon()
        return pokemon
    }
}
