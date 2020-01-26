package com.tran.valentin.lbctest.ui.data.mapper

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.tran.valentin.lbctest.service.model.Album
import com.tran.valentin.lbctest.ui.data.AlbumUiData
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

class AlbumUiDataMapperTest {
    companion object {
        private const val ID = 1L
        private const val TITLE = "title"
        private const val THUMBNAIL_URL = "http://example-url-for-thumbnail"
    }

    private val mapper = AlbumUiDataMapper()
    private val album = mock<Album> {
        on { id } doReturn ID
        on { title } doReturn TITLE
        on { thumbnailUrl } doReturn THUMBNAIL_URL
    }
    private val list = listOf(album)

    @Test
    fun mapAlbumUiData() {
        val result = mapper.mapAlbumUiData(list)
        result.size.shouldEqualTo(1)
        result.first().apply {
            this.id.shouldEqualTo(ID)
            this.imageUrl.shouldEqual(THUMBNAIL_URL)
            this.title.shouldEqual(TITLE)
        }

    }
}