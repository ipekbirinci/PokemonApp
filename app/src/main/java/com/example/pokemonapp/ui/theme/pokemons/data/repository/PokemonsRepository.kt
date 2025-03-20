package com.example.pokemonapp.ui.theme.pokemons.data.repository

import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import kotlinx.coroutines.flow.Flow


interface PokemonsRepository {
    suspend fun getPokemons(): List<Pokemon>
}