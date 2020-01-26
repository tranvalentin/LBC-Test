package com.tran.valentin.lbctest.ui.data.mapper

import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.ui.data.AlbumUiData

class AlbumUiDataMapper {
    fun mapAlbumUiData(albumList: List<Album>): List<AlbumUiData> {
        return albumList.map{
            val uiData = AlbumUiData(it.id!!, it.thumbnailUrl!!, it.title!!)
            uiData
        }
    }
}