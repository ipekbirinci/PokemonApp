package com.example.pokemonapp.ui.theme.pokemons.presantation.screens


import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokemonapp.ui.theme.pokemons.presantation.screens.bs.BottomSheetContent

@Composable
fun PokemonDetailScreen(pokemonName: String, pokemonImageUrl: String, pokemonDescription: String) {
    Scaffold(

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val decodedUrl = decodeBase64ToUrl(pokemonImageUrl)

            Image(
                painter = rememberImagePainter(decodedUrl),
                contentDescription = pokemonName,
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = pokemonName,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = pokemonDescription,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

fun decodeBase64ToUrl(encodedUrl: String): String {
    val decodedBytes = Base64.decode(encodedUrl, Base64.NO_WRAP)
    return String(decodedBytes)
}
