package com.example.pokemonapp.ui.theme.pokemons.presantation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon

@Composable
fun PokemonListItem(pokemon: Pokemon, onClick: () -> Unit, onBottomSheetClick: () -> Unit, onDetailClick: (String, Any?, Any?) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imageUrl="https:"+pokemon.url
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            pokemon.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
            }

            Row {
                IconButton(onClick = { onBottomSheetClick() }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Open Bottom Sheet")
                }

                IconButton(onClick = {
                    pokemon.name?.let { onDetailClick(it, pokemon.url, pokemon.description) }
                }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "Pokemon detail")
                }
            }
        }
    }
}
