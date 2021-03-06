package com.tran.valentin.lbctest.service.manager

import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.service.repository.ILBCRepository
import io.reactivex.Single

//Domain layer where business logic should be
class LBCManager(private val repository: ILBCRepository): ILBCManager {
    override fun getAlbums(): Single<List<Album>> {
        return repository.getAlbums()
    }
}