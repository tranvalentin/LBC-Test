package com.tran.valentin.lbctest.service

import android.app.Application
import com.tran.valentin.lbctest.service.manager.ManagerLocator
import com.tran.valentin.lbctest.service.manager.ManagerProvider

class LBCApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val managerProvider = ManagerProvider(this)
        val managerLocator = ManagerLocator
        managerLocator.setManagerProvider(managerProvider)
        managerLocator.findApiClient().initializeClient()
    }
}