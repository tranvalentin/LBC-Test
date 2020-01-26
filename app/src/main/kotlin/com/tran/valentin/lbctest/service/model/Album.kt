package com.tran.valentin.lbctest.service.model

import com.google.gson.annotations.SerializedName
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import com.tran.valentin.lbctest.service.dao.AlbumDao

@DatabaseTable(tableName = Album.TABLE_NAME, daoClass = AlbumDao::class)
class Album {
    companion object {
        const val TABLE_NAME = "Album"
    }

    @SerializedName("albumId")
    @DatabaseField(columnName = "albumId")
    val albunId: Int? = null
    @SerializedName("id")
    @DatabaseField(columnName = "id", id = true)
    val id: Long? = null
    @SerializedName("title")
    @DatabaseField(columnName = "title")
    val title: String? = null
    @SerializedName("url")
    @DatabaseField(columnName = "url")
    val url: String? = null
    @SerializedName("thumbnailUrl")
    @DatabaseField(columnName = "thumbnailUrl")
    val thumbnailUrl: String? = null
}