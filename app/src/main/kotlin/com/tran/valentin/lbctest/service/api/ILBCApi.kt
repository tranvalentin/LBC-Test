package com.tran.valentin.lbctest.service.api

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single
import retrofit2.http.GET

interface ILBCApi {
    @GET("https://static.leboncoin.fr/img/shared/technical-test.json")
    fun getAlbums(): Single<List<Album>>
}