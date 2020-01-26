package com.tran.valentin.lbctest.service.repository.local

import com.tran.valentin.lbctest.service.dao.AlbumDao
import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Completable
import io.reactivex.Single

class LocalLBCRepository(private val albumDao: AlbumDao) : ILocalLBCRepository {
    override fun findAlbums(): Single<List<Album>> {
        return Single.fromCallable { albumDao.queryForAll() }
    }

    override fun saveAlbums(albumList: List<Album>): Completable {
        return Completable.fromAction {
            albumDao.callBatchTasks {
                albumList.forEach { album ->
                    albumDao.createOrUpdate(album)
                }
            }
        }
    }

    override fun clean(): Completable {
        return Completable.fromAction {
            albumDao.deleteBuilder().delete()
        }
    }
}