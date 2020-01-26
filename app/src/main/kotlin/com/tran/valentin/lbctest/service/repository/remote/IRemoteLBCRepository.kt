package com.tran.valentin.lbctest.service.repository.remote

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single

interface IRemoteLBCRepository {
    fun fetchAlbums(): Single<List<Album>>
}