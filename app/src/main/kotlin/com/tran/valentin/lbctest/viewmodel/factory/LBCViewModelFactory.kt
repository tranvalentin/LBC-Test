package com.tran.valentin.lbctest.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tran.valentin.lbctest.service.manager.ILBCManager
import com.tran.valentin.lbctest.viewmodel.LBCViewModel

class LBCViewModelFactory(
    private val hostApplication: Application,
    private val manager: ILBCManager
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LBCViewModel::class.java)) {
            return LBCViewModel(hostApplication, manager) as T
        }
        throw IllegalArgumentException("This factory can only handle LBCViewModel class")
    }
}