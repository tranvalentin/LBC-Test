package com.tran.valentin.lbctest.service.repository.local

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Completable
import io.reactivex.Single

interface ILocalLBCRepository {
    fun findAlbums(): Single<List<Album>>
    fun saveAlbums(albumList: List<Album>): Completable
    fun clean(): Completable
}