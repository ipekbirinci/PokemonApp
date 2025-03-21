package com.example.pokemonapp.ui.theme.pokemons.presantation.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemonapp.R
import com.example.pokemonapp.ui.theme.pokemons.data.response.Pokemon
import com.example.pokemonapp.ui.theme.pokemons.presantation.PokemonViewModel
import com.example.pokemonapp.ui.theme.pokemons.presantation.screens.bs.BottomSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(navController: NavController, viewModel: PokemonViewModel = hiltViewModel()) {
    val pokemonList by viewModel.pokemonList.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var selectedPokemon by remember { mutableStateOf<Pokemon?>(null) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Pokemon Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 16.dp)
        )

//        LazyColumn {
//            items(pokemonList.size) { index ->
//                val pokemon = pokemonList[index]
//                PokemonListItem(pokemon = pokemon) {
//                    navController.navigate("pokemon_detail/${pokemon.name}")
//                }
//            }
//        }

        LazyColumn {
            items(pokemonList.size) { index ->
                val pokemon = pokemonList[index]

                PokemonListItem(
                    pokemon = pokemon,
                    onClick = { /* On card click */ },
                    onBottomSheetClick = {
                        selectedPokemon = pokemon
                        coroutineScope.launch { sheetState.show() }
                    },
                    onDetailClick = { name, url, description ->
                        navController.navigate("pokemon_detail/$name/$url/$description")
                    }
                )
            }
        }
//        ModalBottomSheet(
//            sheetState = sheetState,
//            onDismissRequest = { coroutineScope.launch { sheetState.hide() } }
//        ) {
//            selectedPokemon?.let { pokemon ->
//                BottomSheetContent(
//                    pokemonName = pokemon.name ?: "No Name",
//                    pokemonDesc = pokemon.description ?: "No Description"
//                )
//            }
//        }

    }
    }

