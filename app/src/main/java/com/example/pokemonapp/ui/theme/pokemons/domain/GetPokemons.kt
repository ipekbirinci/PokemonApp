package com.example.pokemonapp.ui.theme.pokemons.domain

import com.example.pokemonapp.ui.theme.pokemons.data.repository.PokemonsRepository
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetPokemons @Inject constructor(
    private val repository: PokemonsRepository
) {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        loadPokemons()
    }

    fun loadPokemons() {
        coroutineScope.launch {
            repository.getPokemons().collect { pokemonList ->
                _pokemonList.value = pokemonList
            }
        }
    }
}



