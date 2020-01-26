package com.tran.valentin.lbctest.service.manager

import android.content.Context
import com.tran.valentin.lbctest.service.api.ApiClient
import com.tran.valentin.lbctest.service.api.IApiClient
import com.tran.valentin.lbctest.service.dao.AlbumDao
import com.tran.valentin.lbctest.service.database.DatabaseHelper
import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.service.repository.LBCRepository
import com.tran.valentin.lbctest.service.repository.local.LocalLBCRepository
import com.tran.valentin.lbctest.service.repository.remote.RemoteLBCRepository

//Provide managers to ManagerLocator
class ManagerProvider(private val context: Context) : IFactoryManager {
    private val client: IApiClient by lazy { ApiClient() }
    private val databaseHelper: DatabaseHelper by lazy { DatabaseHelper.getInstance(context) }

    override fun getApiClient(): IApiClient = client
    override fun getLBCManager(): ILBCManager {
        val albumDao = databaseHelper.getDao(Album::class.java) as AlbumDao
        val localRepository = LocalLBCRepository(albumDao)
        val remoteRepository = RemoteLBCRepository(client)
        val repository = LBCRepository(localRepository, remoteRepository)
        return LBCManager(repository)
    }
}