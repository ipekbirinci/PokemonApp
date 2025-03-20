package com.example.pokemonapp.ui.theme.pokemons.presantation

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokemonapp.R
import com.example.pokemonapp.base.BaseActivity
import com.example.pokemonapp.ui.theme.PokemonAppTheme
import com.example.pokemonapp.ui.theme.pokemons.presantation.pokemoncards.PokemonCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonsActivity : BaseActivity() {

    private val viewModel: PokemonViewModel by viewModels()

    @Composable
    override fun ProvideContent() {

        PokemonAppTheme {
            Column {
                TopBar()
                LazyColumn {
                    items(viewModel.pokemonList.value) { pokemon ->
                        PokemonCard(pokemon)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            )
        },
        actions = {
            val settingsIcon: Painter = painterResource(id = R.drawable.ic_poke_egg)
            IconButton(
                onClick = { /* Room'daki favoriler */ },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Image(
                    painter = settingsIcon,
                    contentDescription = "Settings"
                )
            }
        }
    )
}

