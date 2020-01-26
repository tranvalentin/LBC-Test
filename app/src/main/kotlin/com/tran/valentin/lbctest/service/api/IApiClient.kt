package com.tran.valentin.lbctest.service.api

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single

interface IApiClient {
    fun initializeClient()
    fun getAlbums(): Single<List<Album>>
}