package com.tran.valentin.lbctest.service.repository.local

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.tran.valentin.lbctest.service.dao.AlbumDao
import com.tran.valentin.lbctest.service.model.Album
import org.junit.Test
import java.util.concurrent.Callable

class LocalLBCRepositoryTest {

    private val album = mock<Album>()
    private val dao = mock<AlbumDao> {
        on { queryForAll() } doReturn listOf(album)
        on { callBatchTasks(org.amshove.kluent.any(Callable::class)) } doReturn album
    }
    private val localRepository = LocalLBCRepository(dao)

    @Test
    fun findAlbums() {
        localRepository.findAlbums().test().assertSubscribed().assertNoErrors()
            .assertValue(listOf(album))
    }

    @Test
    fun saveAlbums() {
        localRepository.saveAlbums(listOf(album)).test().assertSubscribed().assertNoErrors()
            .assertComplete()
    }

    @Test
    fun clean() {
        localRepository.clean()
            .test()
            .assertSubscribed()
            .assertComplete()
            .assertNoErrors()
            .awaitTerminalEvent()

        verify(dao).clearTable()
    }
}