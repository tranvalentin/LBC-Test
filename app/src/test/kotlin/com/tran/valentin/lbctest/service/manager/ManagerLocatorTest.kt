package com.tran.valentin.lbctest.service.manager

import com.nhaarman.mockitokotlin2.whenever
import com.tran.valentin.lbctest.service.api.IApiClient
import org.amshove.kluent.mock
import org.junit.Test
import org.mockito.Mockito

class ManagerLocatorTest {
    private var mockFactoryManager: IFactoryManager = mock(IFactoryManager::class)

    @Test
    fun findApiClient() {
        // Setup
        ManagerLocator.setManagerProvider(mockFactoryManager)
        val apiClient: IApiClient = mock(IApiClient::class)
        whenever(mockFactoryManager.getApiClient()).thenReturn(apiClient)
        // Call
        ManagerLocator.findApiClient()
        // Verify
        Mockito.verify(mockFactoryManager)
            .getApiClient()
    }

    @Test
    fun findLBCManager() {
        // Setup
        ManagerLocator.setManagerProvider(mockFactoryManager)
        val lbcManager: ILBCManager = mock(ILBCManager::class)
        whenever(mockFactoryManager.getLBCManager()).thenReturn(lbcManager)
        // Call
        ManagerLocator.findLBCManager()
        // Verify
        Mockito.verify(mockFactoryManager)
            .getLBCManager()
    }
}