package com.tran.valentin.lbctest.service.manager

object ManagerLocator {
    private lateinit var managerProvider: IFactoryManager

    fun setManagerProvider(managerProvider: IFactoryManager) {
        synchronized(ManagerLocator::class) {
            this.managerProvider = managerProvider
        }
    }

    fun findApiClient() = managerProvider.getApiClient()
    fun findLBCManager() = managerProvider.getLBCManager()
}