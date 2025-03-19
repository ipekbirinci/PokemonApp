package com.example.pokemonapp.ui.theme.pokemons.presantation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.ui.theme.pokemons.data.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            // Örnek veri, burada API çağrısı da yapabilirsin
            _pokemonList.value = listOf(
                Pokemon(1, "Bulbasaur","test", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                Pokemon(2, "Ivysaur", "test","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
                Pokemon(3, "Venusaur", "test","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png")
            )
        }
    }
}
