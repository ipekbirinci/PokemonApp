package com.example.pokemonapp.ui.theme.pokemons.data.repository

import com.example.pokemonapp.ui.theme.pokemons.data.PokemonApiService
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonApiService
) {
    suspend fun getPokemonList(): List<Pokemon> {
        return api.getPokemons()
    }
}

