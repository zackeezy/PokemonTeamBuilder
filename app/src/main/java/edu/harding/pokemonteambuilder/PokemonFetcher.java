package edu.harding.pokemonteambuilder;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.*;

public class PokemonFetcher {
    PokeApi mPokeApi = new PokeApiClient();

    public PokemonSpecies fetchSpecies(int species) {
        return mPokeApi.getPokemonSpecies(species);
    }
}
