package com.ericandpau.pokeshopk.data

import com.ericandpau.pokeshopk.Pokemon
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("/pokemons")
    suspend fun getPokemons(): List<Pokemon>

    @POST("/pokemon/")
    suspend fun addPokemon(
        @Query("nom") name: String,
        @Query("tipo") tipo: String?,
        @Query("altura") altura: Int,
        @Query("img") img: String?
    ): Response<Void>

    @DELETE("/pokemon/{id}")
    suspend fun deletePokemon(@Path("id") id: Int): Response<Unit>

    @GET("/pokemon/search")
    suspend fun searchPokemons(@Query("texto") texto: String): List<Pokemon>
}