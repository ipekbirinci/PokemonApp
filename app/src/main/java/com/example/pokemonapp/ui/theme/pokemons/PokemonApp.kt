package com.example.pokemonapp.ui.theme.pokemons

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapp.ui.theme.pokemons.presantation.screens.PokemonDetailScreen
import com.example.pokemonapp.ui.theme.pokemons.presantation.screens.PokemonScreen

@Composable
fun PokemonApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "pokemon_list") {
        composable("pokemon_list") {
            PokemonScreen(navController)
        }
        composable("pokemon_detail/{pokemonName}/{pokemonUrl}/{pokemonDesc}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            val pokemonUrl = backStackEntry.arguments?.getString("pokemonUrl") ?: ""
            val pokemonDesc = backStackEntry.arguments?.getString("pokemonDesc") ?: ""

            PokemonDetailScreen(pokemonName, pokemonUrl, pokemonDesc)
        }
    }
}