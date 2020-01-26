package com.tran.valentin.lbctest.service.manager

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.service.repository.ILBCRepository
import com.tran.valentin.lbctest.service.repository.LBCRepository
import io.reactivex.Single
import org.junit.Test


class LBCManagerTest {

    private val repository: ILBCRepository = mock<LBCRepository>()
    private val manager = LBCManager(repository)
    private val album = mock<Album>()

    @Test
    fun getAlbums() {
        whenever(repository.getAlbums()).thenReturn(Single.just(listOf(album)))

        manager.getAlbums()
            .test()
            .assertComplete()
            .assertValue { result ->
                result.size == 1 && result.first() == album
            }
    }
}