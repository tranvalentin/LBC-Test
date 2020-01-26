package com.tran.valentin.lbctest.service.repository.remote

import com.tran.valentin.lbctest.service.api.IApiClient
import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single

class RemoteLBCRepository(private val apiClient: IApiClient) : IRemoteLBCRepository {
    override fun fetchAlbums(): Single<List<Album>> {
        return apiClient.getAlbums()
    }
}