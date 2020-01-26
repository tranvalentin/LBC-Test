package com.tran.valentin.lbctest.service.repository

import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.service.repository.local.ILocalLBCRepository
import com.tran.valentin.lbctest.service.repository.remote.IRemoteLBCRepository
import io.reactivex.Single

class LBCRepository(
    private val local: ILocalLBCRepository,
    private val remote: IRemoteLBCRepository
) : ILBCRepository {
    override fun getAlbums(): Single<List<Album>> {
        return local.findAlbums().flatMap {
            if (it.isEmpty()) {
                fetchAndSaveAlbums()
            } else {
                Single.just(it)
            }
        }
    }

    private fun fetchAndSaveAlbums(): Single<List<Album>> {
        return remote.fetchAlbums().flatMap {
            local.clean().andThen(local.saveAlbums(it)).toSingleDefault(it)
        }
    }
}