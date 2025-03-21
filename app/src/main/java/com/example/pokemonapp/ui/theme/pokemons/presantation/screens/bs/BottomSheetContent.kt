package com.example.pokemonapp.ui.theme.pokemons.presantation.screens.bs


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text

import androidx.compose.material3.MaterialTheme

@Composable
fun BottomSheetContent(pokemonName: String, pokemonDesc: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = pokemonName,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = pokemonDesc,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
