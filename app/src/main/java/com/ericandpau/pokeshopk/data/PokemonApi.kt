package com.ericandpau.pokeshopk.data

import com.ericandpau.pokeshopk.Pokemon
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
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

    @PATCH("/pokemon/{id}")
    suspend fun updatePokemon(
        @Path("id") id: Int,
        @Query("nom") nom: String?,
        @Query("tipo") tipo: String?,
        @Query("altura") altura: Int?
    ): Response<Void>



    @DELETE("/pokemon/{id}")
    suspend fun deletePokemon(@Path("id") id: Int): Response<Unit>

    @GET("/search/{texto}")
    suspend fun searchPokemons(@Path("texto") texto: String): List<Pokemon>
}