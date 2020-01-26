package com.tran.valentin.lbctest.service.api

import com.google.gson.Gson
import com.tran.valentin.lbctest.service.model.Album
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient : IApiClient {
    companion object {
        const val BASE_URL = "https://static.leboncoin.fr/"
    }

    private lateinit var client: OkHttpClient
    private lateinit var api: ILBCApi
    private lateinit var retrofit: Retrofit

    override fun initializeClient() {
        client = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
        api = retrofit.create(ILBCApi::class.java)
    }

    override fun getAlbums(): Single<List<Album>> = api.getAlbums()
}