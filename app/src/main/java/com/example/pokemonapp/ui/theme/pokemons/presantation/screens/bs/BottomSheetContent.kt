package com.example.pokemonapp.ui.theme.pokemons.presantation.screens.bs


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
