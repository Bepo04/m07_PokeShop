package com.ericandpau.pokeshopk.data

import com.ericandpau.pokeshopk.Pokemon
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("/pokemons")
    suspend fun getPokemons(): List<Pokemon>

    @DELETE("/pokemon/{id}")
    suspend fun deletePokemon(@Path("id") id: Int): Response<Unit>
}