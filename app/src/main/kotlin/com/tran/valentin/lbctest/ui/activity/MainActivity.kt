package com.tran.valentin.lbctest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.tran.valentin.lbctest.R
import com.tran.valentin.lbctest.service.manager.ManagerLocator
import com.tran.valentin.lbctest.ui.adapter.AlbumAdapter
import com.tran.valentin.lbctest.viewmodel.LBCViewModel
import com.tran.valentin.lbctest.viewmodel.factory.LBCViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val adapter = AlbumAdapter()
    private val compositeDisposable = CompositeDisposable()

    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            LBCViewModelFactory(this.application, ManagerLocator.findLBCManager())
        ).get(LBCViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter

        compositeDisposable.add(
            viewModel.dataSource.subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe { list -> adapter.submitList(list) })
    }
}
