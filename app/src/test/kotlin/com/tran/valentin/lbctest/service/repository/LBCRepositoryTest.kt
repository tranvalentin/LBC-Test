package com.tran.valentin.lbctest.service.repository

import com.nhaarman.mockitokotlin2.*
import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.service.repository.local.ILocalLBCRepository
import com.tran.valentin.lbctest.service.repository.remote.IRemoteLBCRepository
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Test

class LBCRepositoryTest {

    private val album = mock<Album>()
    private val localRepository = mock<ILocalLBCRepository> {
        on { clean() } doReturn Completable.complete()
        on { saveAlbums(listOf(album)) } doReturn Completable.complete()
    }
    private val remoteRepository = mock<IRemoteLBCRepository> {
        on { fetchAlbums() } doReturn Single.just(listOf(album))
    }
    private val repository = LBCRepository(localRepository, remoteRepository)

    @Test
    fun getAlbums_local() {
        whenever(localRepository.findAlbums()).thenReturn(Single.just(listOf(album)))
        repository.getAlbums().test().assertSubscribed().assertNoErrors().assertValue(listOf(album))
    }

    @Test
    fun getAlbums_remote() {
        whenever(localRepository.findAlbums()).thenReturn(Single.just(emptyList()))
        repository.getAlbums().test().assertSubscribed().assertNoErrors().assertValue(listOf(album))

        verify(remoteRepository).fetchAlbums()
        verify(localRepository).saveAlbums(any())
    }
}