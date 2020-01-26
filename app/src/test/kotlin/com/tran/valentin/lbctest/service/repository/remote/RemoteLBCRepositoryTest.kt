package com.tran.valentin.lbctest.service.repository.remote

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.tran.valentin.lbctest.service.api.IApiClient
import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single
import org.junit.Test

class RemoteLBCRepositoryTest {

    private val album = mock<Album>()
    private val apiClient = mock<IApiClient> {
        on { getAlbums() } doReturn Single.just(listOf(album))
    }
    private val remoteLBCRepository = RemoteLBCRepository(apiClient)
    @Test
    fun fetchAlbums() {
        remoteLBCRepository.fetchAlbums().test().assertSubscribed().assertNoErrors().assertValue(
            listOf(album)
        )
    }
}