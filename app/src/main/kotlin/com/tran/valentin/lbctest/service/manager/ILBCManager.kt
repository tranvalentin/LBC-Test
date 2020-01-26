package com.tran.valentin.lbctest.service.manager

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single

interface ILBCManager {
    fun getAlbums(): Single<List<Album>>
}