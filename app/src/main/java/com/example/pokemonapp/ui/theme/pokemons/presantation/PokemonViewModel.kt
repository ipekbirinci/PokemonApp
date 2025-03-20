package com.example.pokemonapp.ui.theme.pokemons.presantation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import com.example.pokemonapp.ui.theme.pokemons.domain.GetPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class PokemonViewModel @Inject constructor(    private val getPokemons: GetPokemons
): ViewModel() {


    val pokemonList: StateFlow<List<Pokemon>> = getPokemons.pokemonList

    init {
        getPokemons.loadPokemons()
    }
}
