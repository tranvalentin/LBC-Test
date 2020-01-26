package com.tran.valentin.lbctest.service.repository

import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single

interface ILBCRepository {
    fun getAlbums(): Single<List<Album>>
}