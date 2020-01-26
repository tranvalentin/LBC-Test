package com.tran.valentin.lbctest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tran.valentin.lbctest.service.manager.ILBCManager
import com.tran.valentin.lbctest.ui.data.AlbumUiData
import com.tran.valentin.lbctest.ui.data.mapper.AlbumUiDataMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.schedulers.Schedulers

class LBCViewModel(hostApplication: Application, private val manager: ILBCManager) :
    AndroidViewModel(hostApplication) {
    val dataSource: BehaviorProcessor<List<AlbumUiData>> = BehaviorProcessor.create()

    private val compositeDisposable = CompositeDisposable()
    private val mapper = AlbumUiDataMapper()

    init {
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(
            manager.getAlbums().map { mapper.mapAlbumUiData(it) }.subscribeOn(
                Schedulers.io()
            ).observeOn(AndroidSchedulers.mainThread()).subscribe { list ->
                dataSource.onNext(list)
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}