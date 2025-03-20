package com.example.pokemonapp.ui.theme.pokemons.data

import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import retrofit2.http.GET

interface PokemonApiService {
        @GET("https://gist.githubusercontent.com/DavidCorrado/8912aa29d7c4a5fbf03993b32916d601/raw")
        suspend fun getPokemons(): List<Pokemon>

}