package com.ericandpau.pokeshopk.data

import com.ericandpau.pokeshopk.Pokemon
import retrofit2.http.GET

interface PokemonApi {

    @GET("/pokemons")
    suspend fun getPokemons(): List<Pokemon>
}