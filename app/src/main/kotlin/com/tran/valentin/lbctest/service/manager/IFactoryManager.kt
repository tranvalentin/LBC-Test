package com.tran.valentin.lbctest.service.manager

import com.tran.valentin.lbctest.service.api.IApiClient

interface IFactoryManager {
    fun getApiClient(): IApiClient
    fun getLBCManager(): ILBCManager
}