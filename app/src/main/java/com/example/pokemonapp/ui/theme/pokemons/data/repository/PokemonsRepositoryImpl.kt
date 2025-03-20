package com.example.pokemonapp.ui.theme.pokemons.data.repository

import com.example.pokemonapp.ui.theme.pokemons.data.datasource.PokemonsDataSource
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PokemonsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonsDataSource
) : PokemonsRepository {
    override suspend fun getPokemons(): List<Pokemon> {
        return dataSource.getPokemons()
    }
}