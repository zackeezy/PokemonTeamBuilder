package edu.harding.pokemonteambuilder

import android.support.compat.R.id.async
import me.sargunvohra.lib.pokekotlin.client.PokeApi
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.*
import org.jetbrains.anko.doAsync

class PokemonFetcher {
    private var mPokeApi: PokeApi = PokeApiClient()

    fun fetchSpecies(pokedexIndex: Int): PokemonSpecies {
        return mPokeApi.getPokemonSpecies(pokedexIndex)
    }

    fun speciesToPokemon(species: PokemonSpecies): Pokemon {
        var pokemon = Pokemon()
        return pokemon
    }
}
