package com.example.pokemonapp.ui.theme.pokemons.data.response


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

@Entity
data class Pokemon(
    val id: Int?=null,
    val name: String?=null,
    val description: String?=null,
    val imageUrl: String?=null
)

