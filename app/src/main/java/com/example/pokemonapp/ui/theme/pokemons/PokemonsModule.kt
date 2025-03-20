package com.example.pokemonapp.ui.theme.pokemons

import com.example.pokemonapp.ui.theme.pokemons.data.PokemonApiService
import com.example.pokemonapp.ui.theme.pokemons.data.datasource.PokemonsDataSource
import com.example.pokemonapp.ui.theme.pokemons.data.repository.PokemonsRepository
import com.example.pokemonapp.ui.theme.pokemons.data.repository.PokemonsRepositoryImpl
import com.example.pokemonapp.ui.theme.pokemons.domain.GetPokemons
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonsModule {

    @Singleton
    @Provides
    fun providePokemonsRepository(dataSource: PokemonsDataSource): PokemonsRepository {
        return PokemonsRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun providePokemonApiService(retrofit: Retrofit): PokemonApiService =
        retrofit.create(PokemonApiService::class.java)

    @Singleton
    @Provides
    fun providePokemonsDataSource(apiService: PokemonApiService): PokemonsDataSource {
        return PokemonsDataSource(apiService)
    }
    @Singleton
    @Provides
    fun providePokemonsCharacters(repository: PokemonsRepository): GetPokemons {
        return GetPokemons(repository)
    }
}