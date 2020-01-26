package com.tran.valentin.lbctest.service.dao

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.DatabaseTableConfig
import com.tran.valentin.lbctest.service.model.Album
import java.sql.SQLException

class AlbumDao : BaseDaoImpl<Album, Long> {
    fun clearTable() {
        deleteBuilder().delete()
    }

    @Throws(SQLException::class)
    constructor(
        connectionSource: ConnectionSource,
        tableConfig: DatabaseTableConfig<Album>?
    ) : super(connectionSource, tableConfig)

    @Throws(SQLException::class)
    constructor(connectionSource: ConnectionSource) : super(connectionSource, Album::class.java)
}