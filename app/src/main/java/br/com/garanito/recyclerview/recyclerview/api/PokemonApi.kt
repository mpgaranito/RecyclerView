package br.com.garanito.recyclerview.recyclerview.api

import br.com.garanito.recyclerview.recyclerview.model.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi{

    @GET("/api/pokemon")
    fun buscar(@Query("size") size: Int) : Observable<PokemonResponse>
}